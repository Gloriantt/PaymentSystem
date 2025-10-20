package by.antonpaulavets.paymentsystem.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class CardRequestDTO {
    @NotNull
    private Long userId;
    @NotBlank
    @Size(min = 12,max=19)
    private String number;
    @NotBlank
    private String holder;
    @Future
    private LocalDate expirationDate;
}