package pl.myprojects.loganto.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.myprojects.loganto.models.Account;
import pl.myprojects.loganto.models.Charge;
import pl.myprojects.loganto.reposiotories.AccountRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    AccountRepository accountRepository;

    public void updateBalances() {
        var accounts = accountRepository.findAll().stream().map(this::updateBalance).toList();
        accountRepository.saveAll(accounts);
    }


    public Account updateBalance(Account account) {
        BigDecimal unpaidDueCharges = account.getCharges().stream()
                .filter(charge ->
                        charge.getChargeDateTime().isAfter(account.getBalanceDateTime()) &&
                                charge.isDue())
                .map(Charge::getAmount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        account.setBalance(account.getBalance().subtract(unpaidDueCharges));
        account.setBalanceDateTime(LocalDateTime.now());
        return account;
    }
}
