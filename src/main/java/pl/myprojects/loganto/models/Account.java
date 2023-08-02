package pl.myprojects.loganto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apartment_Id")
    private Long apartmentId;

    private BigDecimal balance;
    private LocalDateTime balanceDateTime;

    @OneToMany
    private Set<Charge> charges;

    @OneToMany
    private Set<Payment> payments;

    public void addCharge(Charge charge) {
        charges.add(charge);
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
        balance = balance.add(payment.getAmount());
        updateBalance();
    }


    public void updateBalance() {
        charges.forEach(Charge::setChargeAsDue);
        BigDecimal amountToSubtract = charges.stream()
                .filter(charge ->
                        charge.getChargeDateTime().isAfter(balanceDateTime) &&
                                charge.getIsDue())
                .map(Charge::getAmount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        balance = balance.subtract(amountToSubtract);
        balanceDateTime = LocalDateTime.now();



    }

}
