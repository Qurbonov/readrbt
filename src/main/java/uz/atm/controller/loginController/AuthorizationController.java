package uz.atm.controller.loginController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.atm.dto.auth.LoginResponse;
import uz.atm.dto.auth.ProfileDetailDTO;
import uz.atm.services.auth.AuthorizationService;


/**
 * Author: Khonimov Ulugbek
 * Date: 06/07/22
 * Time: 10:47
 */
@RequestMapping("/v1/atm")
@Slf4j
@RestController
@RequiredArgsConstructor

public class AuthorizationController {

    private final AuthorizationService authorizationService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody ProfileDetailDTO dto) {
        log.info("Login {}", dto);
        return ResponseEntity.status(authorizationService.login(dto).getStatus() ? 200 : 409).body(authorizationService.login(dto));
    }
}
