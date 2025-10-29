package by.antonpaulavets.paymentsystem.repository;


import by.antonpaulavets.paymentsystem.models.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardInfoRepository extends JpaRepository<CardInfo, Long> {
}
