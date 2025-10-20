package by.antonpaulavets.paymentsystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class CardResponseDTO {
    private Long id;
    private Long userId;
    private String number;
    private String holder;
    private LocalDate expirationDate;
}
