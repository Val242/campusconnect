package valycodes.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valycodes.campusconnect.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
     boolean existsByEmail(String username);
     Optional<User> findByEmail(String email);
}
