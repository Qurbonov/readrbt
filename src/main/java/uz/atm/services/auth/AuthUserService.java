package uz.atm.services.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.atm.config.encoder.PassEncoder;
import uz.atm.dto.auth.*;
import uz.atm.enums.Status;
import uz.atm.exceptions.AppBadRequestException;
import uz.atm.exceptions.UserAlreadyExistException;
import uz.atm.exceptions.UserNotFoundException;
import uz.atm.mapper.auth.AuthUserMapper;
import uz.atm.model.auth.AuthUser;
import uz.atm.repository.AuthUserRepository;
import uz.atm.services.AbstractService;
import uz.atm.services.GenericService;
import uz.atm.utils.JwtUtil;

import java.util.List;
import java.util.Optional;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:01
 */

@Service
public class AuthUserService extends AbstractService<AuthUserRepository> implements UserDetailsService, GenericService<
        AuthUserDto, AuthUserUpdateDto, AuthUserCreateDto, Long> {

    private final AuthUserMapper authUserMapper;
    private final PassEncoder passEncoder;

    public AuthUserService(AuthUserRepository repository, AuthUserMapper authUserMapper, PassEncoder passEncoder) {
        super(repository);
        this.authUserMapper = authUserMapper;
        this.passEncoder = passEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> optional = repository.findByUsernameAndDeletedFalse(username);
        if (optional.isPresent()) {
            AuthUser user = optional.get();
            if (user.getStatus().equals(Status.ACTIVE)) {
                return User.builder().username(user.getUsername()).password(user.getPassword()).authorities(new SimpleGrantedAuthority(user.getRole().name())).build();
            } else throw new AppBadRequestException("User Not Active");
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    /**
     * @param dto -> username, password
     * @return Token
     */
    public ResponseEntity<LoginResponse> login(ProfileDetailDTO dto) {

        Optional<AuthUser> authUser = repository.findByUsernameAndDeletedFalse(dto.username);

        if (authUser.isEmpty()) {
            return ResponseEntity.badRequest().body(new LoginResponse(false, "Check your username!!!", false));
        }
        boolean matches = passEncoder.passwordEncoder().matches(dto.password, authUser.get().getPassword());

        if (!matches) {
            return ResponseEntity.badRequest().body(new LoginResponse(false, "Check your password!!!", true));
        }

        if (authUser.get().getStatus().equals(Status.BLOCK)) {
            return ResponseEntity.badRequest().body(new LoginResponse(false, "Your account is blocked!!!", true));
        }

        String token = JwtUtil.encode(authUser.get().getUsername(), authUser.get().getRole());

        return ResponseEntity.ok().body(new LoginResponse(true, "You are login successfully", true, token));
    }


    @Override
    public AuthUserDto create(AuthUserCreateDto createDto) throws UserAlreadyExistException {
        try {
            AuthUser authUser = authUserMapper.fromCreateDto(createDto);
            authUser.setPassword(passEncoder.passwordEncoder().encode(createDto.password));
            AuthUser save = repository.save(authUser);
            return authUserMapper.toDto(save);
        } catch (Exception e) {
            throw new UserAlreadyExistException("User already exist with this Username : " + createDto.username);
        }
    }

    @Override
    public Long update(AuthUserUpdateDto updateDto) {
        Long id = updateDto.id;
        Optional<AuthUser> authUser = repository.findByIdAndDeletedFalse(id);
        AuthUser dbUser = authUser.get();
        AuthUser user = authUserMapper.fromUpdateDto(updateDto, dbUser);
        repository.save(user);
        return updateDto.id;
    }

    @Override
    public Long delete(Long id) throws UserNotFoundException {
        Optional<AuthUser> byId = repository.findByIdAndDeletedFalse(id);
        if (byId.isPresent()) {
            AuthUser authUser = byId.get();
            authUser.setDeleted(true);
            repository.save(authUser);
            return id;
        } else throw new UserNotFoundException("User not found with id : " + id);
    }

    @Override
    public AuthUserDto get(Long id) throws UserNotFoundException {
        Optional<AuthUser> byId = repository.findByIdAndDeletedFalse(id);
        if (byId.isPresent()) {
            return authUserMapper.toDto(byId.get());
        } else throw new UserNotFoundException("User not found with id : " + id);
    }

    @Override
    public List<AuthUserDto> getAll() {
        return authUserMapper.toDto(repository.findAllByDeletedFalse());
    }


    public Long changeStatus(Long id, Status status) throws UserNotFoundException {
        Optional<AuthUser> byId = repository.findByIdAndDeletedFalse(id);
        if (byId.isPresent()) {
            AuthUser authUser = byId.get();
            authUser.setStatus(status);
            repository.save(authUser);
            return id;
        } else throw new UserNotFoundException("User not found with id : " + id);
    }

    public Long resetPassword(AuthResetPasswordDto dto) {
        Optional<AuthUser> byIdAndDeletedFalse = repository.findByIdAndDeletedFalse(dto.id);
        if (byIdAndDeletedFalse.isPresent()) {
            AuthUser authUser = byIdAndDeletedFalse.get();
            if (passEncoder.passwordEncoder().matches(dto.oldPassword, authUser.getPassword())) {
                authUser.setPassword(passEncoder.passwordEncoder().encode(dto.newPassword));
                repository.save(authUser);
                return dto.id;
            } else throw new AppBadRequestException("Mismatch password");
        } else throw new UserNotFoundException();
    }
}
