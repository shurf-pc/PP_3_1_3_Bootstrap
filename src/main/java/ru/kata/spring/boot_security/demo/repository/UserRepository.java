package ru.kata.spring.boot_security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String username);

    @Query("SELECT u FROM User u JOIN FETCH u.authorities WHERE u.username = :username")
    User findByUsernameWithRoles(@Param("username") String username);

    @Query("SELECT u FROM User u JOIN FETCH u.authorities WHERE u.email = :email")
    User findByEmailWithRoles(@Param("email") String email);
}
