package uz.atm.mapper;

import org.mapstruct.MappingTarget;
import uz.atm.dto.BaseDto;
import uz.atm.dto.GenericDto;
import uz.atm.model.BaseEntity;

import java.util.List;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 */

public interface BaseMapper<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends BaseDto,
        UD extends GenericDto> extends GenericMapper {

    D toDto(E e);

    List<D> toDto(List<E> e);

    E fromCreateDto(CD cd);

    E fromUpdateDto(UD ud, @MappingTarget E entity);

}