package uz.atm.services;

import uz.atm.dto.BaseDto;
import uz.atm.dto.GenericDto;
import uz.atm.exceptions.UserAlreadyExistException;
import uz.atm.exceptions.UserNotFoundException;

import java.io.Serializable;
import java.util.List;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:24
 */
public interface GenericService<
        D extends GenericDto,
        UD extends GenericDto,
        CD extends BaseDto,
        I extends Serializable> {

    D create(CD createDto) throws UserAlreadyExistException;

    I update(UD updateDto);

    I delete(I id) throws UserNotFoundException;

    D get(I id) throws UserNotFoundException;

    List<D> getAll();


}
