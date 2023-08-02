package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myprojects.loganto.models.Owner;
import pl.myprojects.loganto.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
