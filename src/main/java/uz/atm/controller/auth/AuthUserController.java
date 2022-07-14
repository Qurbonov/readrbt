package uz.atm.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.dto.auth.AuthResetPasswordDto;
import uz.atm.dto.auth.AuthUserCreateDto;
import uz.atm.dto.auth.AuthUserDto;
import uz.atm.dto.auth.AuthUserUpdateDto;
import uz.atm.enums.Status;
import uz.atm.exceptions.UserAlreadyExistException;
import uz.atm.exceptions.UserNotFoundException;
import uz.atm.services.auth.AuthUserService;

import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 11:27
 */
@CrossOrigin(origins = "http://192.168.254.145:3085")
@RestController
@RequestMapping("/v1/atm/auth")
public class AuthUserController {

    private final AuthUserService service;


    public AuthUserController(AuthUserService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AuthUserCreateDto createDto) {
        try {
            AuthUserDto authUserDto = service.create(createDto);
            return new ResponseEntity<>(authUserDto, HttpStatus.CREATED);
        } catch (UserAlreadyExistException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AuthUserUpdateDto updateDto) {
        try {
            Long id = service.update(updateDto);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            Long newID = service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @PatchMapping("/block/{id}")
    public ResponseEntity<?> block(@PathVariable("id") Long id) {
        try {
            Long newID = service.changeStatus(id, Status.BLOCK);
            return new ResponseEntity<>(newID, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/active/{id}")
    public ResponseEntity<?> active(@PathVariable("id") Long id) {
        try {
            Long newID = service.changeStatus(id, Status.ACTIVE);
            return new ResponseEntity<>(newID, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/resetPassword")
    public ResponseEntity<?> active(@RequestBody AuthResetPasswordDto dto) {
        try {
            Long newID = service.resetPassword(dto);
            return new ResponseEntity<>(newID, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        try {
            AuthUserDto authUserDto = service.get(id);
            return new ResponseEntity<>(authUserDto, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthUserDto>> getById() {
        List<AuthUserDto> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
