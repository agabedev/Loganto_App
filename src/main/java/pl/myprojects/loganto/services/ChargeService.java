package pl.myprojects.loganto.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.myprojects.loganto.reposiotories.ChargeRepository;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ChargeService {
    private final ChargeRepository chargeRepository;


}
