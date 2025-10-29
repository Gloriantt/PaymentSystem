package by.antonpaulavets.PaymentProject.repository;

import by.antonpaulavets.PaymentProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
