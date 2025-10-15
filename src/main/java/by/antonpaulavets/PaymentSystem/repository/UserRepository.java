package by.antonpaulavets.PaymentSystem.repository;


import by.antonpaulavets.PaymentSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> getUserByEmailJPQL(@Param("email") String email);
    @Query(value = "SELECT * FROM users WHERE email = :email", nativeQuery = true)
    Optional<User> getUserByEmailNative(@Param("email") String email);

}
