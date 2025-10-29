package by.antonpaulavets.paymentsystem.service;


import by.antonpaulavets.paymentsystem.mapper.MapStructMapper;
import by.antonpaulavets.paymentsystem.models.User;
import by.antonpaulavets.paymentsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private MapStructMapper mapper;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @Transactional
    public User updateUser(Long id, User updatedInfoUser) {
        User existing = getUserById(id);
        existing.setName(updatedInfoUser.getName());
        existing.setSurname(updatedInfoUser.getSurname());
        existing.setBirthDate(updatedInfoUser.getBirthDate());
        existing.setEmail(updatedInfoUser.getEmail());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
