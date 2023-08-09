package pl.myprojects.loganto.reposiotories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.myprojects.loganto.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
