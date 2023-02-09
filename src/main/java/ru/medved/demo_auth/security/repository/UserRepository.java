package ru.medved.demo_auth.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.medved.demo_auth.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String username);
    Boolean existsByLogin(String login);
}
