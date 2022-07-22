package uz.atm.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * Author: Bekpulatov Shoxruh
 * Date: 22/07/22
 * Time: 09:55
 */
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class SubAuditable extends Auditable {

    @LastModifiedDate
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private boolean deleted = false;

}
