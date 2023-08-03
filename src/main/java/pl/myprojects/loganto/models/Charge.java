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

    @Column(name = "account_id")
    private Long accountId;

    private LocalDateTime chargeDateTime;
    private BigDecimal amount;


    public boolean isDue(){
        return !chargeDateTime.isAfter(LocalDateTime.now());
    }
}
