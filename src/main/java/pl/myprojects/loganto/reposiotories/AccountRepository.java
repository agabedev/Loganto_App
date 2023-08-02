package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myprojects.loganto.models.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
