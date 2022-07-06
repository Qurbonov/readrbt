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


@RequestMapping("api/atm")
@Slf4j
@RestController
@RequiredArgsConstructor
//@Api(tags = "Authorization")
public class AuthorizationController {

    private final AuthorizationService authorizationService;


//    @ApiOperation(value = "Login", notes = "Method used for login")
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody ProfileDetailDTO dto){
        log.info("Login {}", dto);
        return ResponseEntity.ok().body(authorizationService.login(dto));
    }
}
