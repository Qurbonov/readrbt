package uz.atm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.atm.model.responseAuction.ResponseAuction;

import java.util.List;
import java.util.Optional;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 29/06/22
 * Time: 14:52
 */
public interface ResponseAuctionRepository extends JpaRepository<ResponseAuction, Long> {

    List<ResponseAuction> findAllByPayload_LotId(Long payload_lotId);
}
