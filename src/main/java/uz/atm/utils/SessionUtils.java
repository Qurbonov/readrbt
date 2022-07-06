package uz.atm.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.atm.model.auth.AuthUser;
import uz.atm.repository.AuthUserRepository;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 15:05
 */
@Component
public class SessionUtils {
    private final AuthUserRepository authUserRepository;

    public SessionUtils(AuthUserRepository authUserRepository) {
        this.authUserRepository = authUserRepository;
    }

    public Long getSessionId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        AuthUser authUser = authUserRepository.findByUsernameAndDeletedFalse(username).get();
        return authUser.getId();

    }
}
