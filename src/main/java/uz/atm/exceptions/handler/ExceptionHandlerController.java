package uz.atm.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.atm.exceptions.AppBadRequestException;
import uz.atm.exceptions.AppForbiddenException;
import uz.atm.exceptions.TokenNotValidException;

import javax.persistence.NonUniqueResultException;
import java.sql.SQLException;


/**
 * Author: Khonimov Ulugbek
 * Date: 07/07/22
 * Time: 17:44
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler({
            AppBadRequestException.class,
            NullPointerException.class,
            IllegalArgumentException.class,
            NonUniqueResultException.class,
            SQLException.class})
    public ResponseEntity<?> handleBadRequestException(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler({
            TokenNotValidException.class,
            UsernameNotFoundException.class,
            BadCredentialsException.class})
    public ResponseEntity<?> handleTokenException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }


    @ExceptionHandler({AppForbiddenException.class})
    public ResponseEntity<?> handleForbiddenException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

}
