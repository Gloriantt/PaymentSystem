package by.antonpaulavets.paymentsystem.dto;

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
public class CardInfoDTO {
    private Long id;
    private Long userId;
    @NotBlank
    @Size(max=16)
    private String number;
    @NotNull
    @Size(max=50)
    private String holder;
    private LocalDate expirationDate;
}
