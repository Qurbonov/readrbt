package uz.atm.mapper.blackList;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.atm.dto.blackList.BlackListCreateDto;
import uz.atm.model.blackList.BlackList;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 15:12
 */
@Component
@Mapper(componentModel = "spring")
public interface BlackListMapper {

    BlackList fromCreateDto(BlackListCreateDto createDto);

}
