package uz.atm.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.MappedSuperclass;

/**
 * @author Bekpulatov Shoxruh
 * createdAt 27/06/22
 */


public abstract class AbstractService<R extends JpaRepository> {

    protected R repository;

    protected ObjectMapper mapper = new ObjectMapper();

    public AbstractService(R repository) {
        this.repository = repository;
    }
}
