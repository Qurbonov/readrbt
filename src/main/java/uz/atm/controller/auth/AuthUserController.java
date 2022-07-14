package uz.atm.controller.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.atm.dto.auth.AuthResetPasswordDto;
import uz.atm.dto.auth.AuthUserCreateDto;
import uz.atm.dto.auth.AuthUserDto;
import uz.atm.dto.auth.AuthUserUpdateDto;
import uz.atm.enums.Status;
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

        AuthUserDto authUserDto = service.create(createDto);
        return new ResponseEntity<>(authUserDto, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody AuthUserUpdateDto updateDto) {
        Long id = service.update(updateDto);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        Long newID = service.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/block/{id}")
    public ResponseEntity<?> block(@PathVariable("id") Long id) {
        Long newID = service.changeStatus(id, Status.BLOCK);
        return new ResponseEntity<>(newID, HttpStatus.OK);

    }

    @PatchMapping("/active/{id}")
    public ResponseEntity<?> active(@PathVariable("id") Long id) {
        Long newID = service.changeStatus(id, Status.ACTIVE);
        return new ResponseEntity<>(newID, HttpStatus.OK);
    }

    @PatchMapping("/resetPassword")
    public ResponseEntity<Long> active(@RequestBody AuthResetPasswordDto dto) {
        Long newID = service.resetPassword(dto);
        return new ResponseEntity<>(newID, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        AuthUserDto authUserDto = service.get(id);
        return new ResponseEntity<>(authUserDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthUserDto>> getById() {
        List<AuthUserDto> all = service.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

}
