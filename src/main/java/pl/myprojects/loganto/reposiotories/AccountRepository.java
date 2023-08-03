package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.myprojects.loganto.models.Account;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface AccountRepository extends JpaRepository<Account, Long> {

//    @Query(nativeQuery = true, value = "update ")
//void updateBalances();
}
