package by.antonpaulavets.paymentsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Data
@Getter
@Setter
public class UserRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @Past
    private LocalDate birthDate;
    @NotBlank
    @Email
    private String email;
}
