package uz.atm.services.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.atm.config.encoder.PassEncoder;
import uz.atm.dto.auth.LoginResponse;
import uz.atm.dto.auth.ProfileDetailDTO;
import uz.atm.enums.Status;
import uz.atm.model.auth.AuthUser;
import uz.atm.repository.AuthUserRepository;
import uz.atm.util.JwtUtil;

import java.util.Optional;


/**
 * Author: Khonimov Ulugbek
 * Date: 06/07/22
 * Time: 10:47
 */
@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final AuthUserRepository authUserRepository;
    private final PassEncoder passEncoder;

    /**
     *
     * @param dto -> username, password
     * @return Token
     */
    public ResponseEntity<LoginResponse> login(ProfileDetailDTO dto) {

        Optional<AuthUser> authUser = authUserRepository.findByUsernameAndDeletedFalse(dto.getUsername());

        if (authUser.isEmpty()) {
            return ResponseEntity.badRequest().body(new LoginResponse(false, "Check your username!!!", false));
        }
        boolean matches = passEncoder.passwordEncoder().matches(dto.getPassword(), authUser.get().getPassword());

        if (!matches) {
            return ResponseEntity.badRequest().body(new LoginResponse(false, "Check your password!!!", true));
        }

        if (authUser.get().getStatus().equals(Status.BLOCK)) {
            return ResponseEntity.badRequest().body(new LoginResponse(false, "Your account is blocked!!!", true));
        }

        String token = JwtUtil.encode(authUser.get().getUsername(),authUser.get().getRole());

        return ResponseEntity.ok().body(new LoginResponse(true, "You are login successfully", true, token));
    }
}
