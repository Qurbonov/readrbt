package uz.atm.mapper.auth;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.atm.dto.auth.AuthUserCreateDto;
import uz.atm.dto.auth.AuthUserDto;
import uz.atm.dto.auth.AuthUserUpdateDto;
import uz.atm.mapper.BaseMapper;
import uz.atm.model.auth.AuthUser;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:39
 */
@Component
@Mapper(componentModel = "spring")
public interface AuthUserMapper extends BaseMapper<
        AuthUser,
        AuthUserDto,
        AuthUserCreateDto,
        AuthUserUpdateDto> {
}
