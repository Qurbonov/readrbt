package uz.atm.services.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.atm.config.encoder.PassEncoder;
import uz.atm.dto.auth.LoginResponse;
import uz.atm.dto.auth.ProfileDetailDTO;
import uz.atm.enums.Status;
import uz.atm.model.auth.AuthUser;
import uz.atm.repository.AuthUserRepository;
import uz.atm.util.JwtUtil;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorizationService {
    private final AuthUserRepository authUserRepository;
    private final PassEncoder passEncoder;

    public LoginResponse login(ProfileDetailDTO dto) {

        Optional<AuthUser> authUser = authUserRepository.findByUsernameAndDeletedFalse(dto.getUsername());

        if (authUser.isEmpty()) {
            return new LoginResponse(false, "Check your username!!!", false);
        }
        boolean matches = passEncoder.passwordEncoder().matches(dto.getPassword(), authUser.get().getPassword());
        if (!matches) {
            return new LoginResponse(false, "Check your password!!!", true);
        }

        if (authUser.get().getStatus().equals(Status.BLOCK)) {
            return new LoginResponse(false, "Your account is blocked!!!", true);
        }

        dto.setToken(JwtUtil.encode(dto.getUsername()));

        return new LoginResponse(true, "You are login successfully", true, dto);
    }
}
