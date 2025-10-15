package by.antonpaulavets.PaymentSystem.repository;


import by.antonpaulavets.PaymentSystem.models.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
}
