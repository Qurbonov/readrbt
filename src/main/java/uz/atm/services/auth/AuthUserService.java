package uz.atm.services.auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.atm.enums.Status;
import uz.atm.model.auth.AuthUser;
import uz.atm.repository.AuthUserRepository;
import uz.atm.services.AbstractService;

import java.util.Optional;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:01
 */

@Service
public class AuthUserService extends AbstractService<AuthUserRepository> implements UserDetailsService {

    public AuthUserService(AuthUserRepository repository) {
        super(repository);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> optional = repository.findByUsername(username);
        if (optional.isPresent()) {
            AuthUser user = optional.get();
            if (user.getStatus().equals(Status.ACTIVE)) {
                return User.builder().username(user.getUsername()).password(user.getPassword()).authorities(new SimpleGrantedAuthority(user.getRole().name())).build();
            } else throw new RuntimeException("User Not Active");
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
