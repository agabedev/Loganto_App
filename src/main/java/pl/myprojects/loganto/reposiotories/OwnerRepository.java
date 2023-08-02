package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myprojects.loganto.models.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
