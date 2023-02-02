package ru.medved.demo_auth.security.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.medved.demo_auth.enums.RoleUser;
import ru.medved.demo_auth.security.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleUser name);
}
