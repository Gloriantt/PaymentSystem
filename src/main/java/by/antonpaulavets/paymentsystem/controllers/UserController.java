package by.antonpaulavets.paymentsystem.controllers;

import by.antonpaulavets.paymentsystem.dto.UserRequestDTO;
import by.antonpaulavets.paymentsystem.dto.UserResponseDTO;
import by.antonpaulavets.paymentsystem.mapper.MapStructMapper;
import by.antonpaulavets.paymentsystem.models.User;
import by.antonpaulavets.paymentsystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final MapStructMapper mapper;

    @PostMapping
    public ResponseEntity<UserResponseDTO> create(@RequestBody UserRequestDTO dto) {
        User created = userService.createUser(mapper.userRequestDtoToUser(dto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(mapper.userToUserResponseDto(created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(mapper.userToUserResponseDto(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        List<UserResponseDTO> list = userService.getAllUsers(PageRequest.of(page, size))
                .map(mapper::userToUserResponseDto)
                .getContent();

        return ResponseEntity.ok(list);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserRequestDTO dto) {
        User updated = userService.updateUser(id, mapper.userRequestDtoToUser(dto));
        return ResponseEntity.ok(mapper.userToUserResponseDto(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}