package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myprojects.loganto.models.Charge;


public interface ChargeRepository extends JpaRepository<Charge, Long> {
}
