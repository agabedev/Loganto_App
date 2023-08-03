package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.myprojects.loganto.models.Charge;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;


public interface ChargeRepository extends JpaRepository<Charge, Long> {

//    Set<Charge> findChargesByChargeDateTimeAfterAndIsDue(LocalDateTime chargeDateTime, Boolean isDue);

//    @Query(nativeQuery = true, value = "")
//    BigDecimal dupa();
}
