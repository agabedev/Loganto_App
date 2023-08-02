package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myprojects.loganto.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
