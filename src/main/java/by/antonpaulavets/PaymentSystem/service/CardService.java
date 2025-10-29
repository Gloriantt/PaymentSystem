package by.antonpaulavets.paymentsystem.service;

import by.antonpaulavets.paymentsystem.models.CardInfo;
import by.antonpaulavets.paymentsystem.repository.CardInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    private CardInfoRepository cardRepo;

    public CardInfo createCard(CardInfo card) {
        return cardRepo.save(card);
    }

    public CardInfo getCardById(Long id) {
        return cardRepo.findById(id).orElseThrow(() -> new RuntimeException("Card not found"));
    }

    public List<CardInfo> getAllCards(int page, int size) {
        return cardRepo.findAll(PageRequest.of(page, size)).getContent();
    }

    public void deleteCard(Long id) {
        cardRepo.deleteById(id);
    }
}
