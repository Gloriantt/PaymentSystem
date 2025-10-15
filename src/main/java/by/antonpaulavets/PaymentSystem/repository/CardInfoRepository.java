package by.antonpaulavets.PaymentProject.repository;

import by.antonpaulavets.PaymentProject.models.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardInfoRepository extends JpaRepository<CardInfo,Long> {
}
