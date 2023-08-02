package pl.myprojects.loganto.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "apartment_id")
    private Long apartmentId;

    private LocalDateTime chargeDateTime;
    private BigDecimal amount;

    private Boolean isDue = false;

    public void setChargeAsDue() {
        if (!chargeDateTime.isAfter(LocalDateTime.now()))
            setIsDue(true);
    }
}
