package by.antonpaulavets.paymentsystem.service;


import by.antonpaulavets.paymentsystem.dto.UserDTO;
import by.antonpaulavets.paymentsystem.mapper.MapStructMapper;
import by.antonpaulavets.paymentsystem.models.User;
import by.antonpaulavets.paymentsystem.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    private final MapStructMapper mapper;

    @Transactional
    public UserDTO updateUser(Long id, UserDTO userDto) {
        User existingUser = userRepository.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));
        User updatedUser = mapper.userDtoToUser(userDto);
        updatedUser.setId(existingUser.getId());
        return mapper.userToUserDto(userRepository.save(updatedUser));
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<User> getAllUsers(int page, int size) {
        return userRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Not found"));
    }

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
