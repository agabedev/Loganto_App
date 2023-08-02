package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myprojects.loganto.models.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Long>{
}
