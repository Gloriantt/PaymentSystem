package by.antonpaulavets.paymentsystem.controllers;

import by.antonpaulavets.paymentsystem.models.CardInfo;
import by.antonpaulavets.paymentsystem.models.User;
import by.antonpaulavets.paymentsystem.repository.CardInfoRepository;
import by.antonpaulavets.paymentsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardInfoRepository cardInfoRepository;


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @PostMapping("/{userId}/cards")
    public CardInfo addCard(@PathVariable Long userId, @RequestBody CardInfo cardInfo) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            cardInfo.setUser(userOpt.get());
            return cardInfoRepository.save(cardInfo);
        } else {
            throw new RuntimeException("User not found");
        }
    }


    @GetMapping("/{userId}/cards")
    public List<CardInfo> getUserCards(@PathVariable Long userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        return userOpt.map(User::getCards).orElseThrow(() -> new RuntimeException("User not found"));
    }
}