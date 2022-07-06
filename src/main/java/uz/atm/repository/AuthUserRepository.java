package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.auth.AuthUser;

import java.util.List;
import java.util.Optional;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 06/07/22
 * Time: 10:02
 */
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {

    Optional<AuthUser> findByUsernameAndDeletedFalse(String username);

    Optional<AuthUser> findByIdAndDeletedFalse(Long id);

    List<AuthUser> findAllByDeletedFalse();
}
