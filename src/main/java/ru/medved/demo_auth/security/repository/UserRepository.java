package ru.medved.demo_auth.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.medved.demo_auth.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String username);
    Boolean existsByName(String username);
    Boolean existsByEmail(String email);
}
