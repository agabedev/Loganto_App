package pl.myprojects.loganto.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.myprojects.loganto.models.Role;
import pl.myprojects.loganto.models.User;
import pl.myprojects.loganto.reposiotories.RoleRepository;
import pl.myprojects.loganto.reposiotories.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUserWithRoles(String username, String password, List<String> roleNames) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
//        user.setPassword(passwordEncoder().encode(password));

        for (String roleName : roleNames) {
            Role role = roleRepository.findByName(roleName);
            if (role != null) {
                user.getRoles().add(role);
            }
        }

        return userRepository.save(user);
    }
//    private PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
