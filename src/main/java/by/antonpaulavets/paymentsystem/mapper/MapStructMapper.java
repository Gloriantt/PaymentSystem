package by.antonpaulavets.paymentsystem.mapper;

import by.antonpaulavets.paymentsystem.dto.CardInfoDTO;
import by.antonpaulavets.paymentsystem.dto.UserDTO;
import by.antonpaulavets.paymentsystem.models.CardInfo;
import by.antonpaulavets.paymentsystem.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    UserDTO userToUserDto(User user);
    User userDtoToUser(UserDTO userDto);
    CardInfoDTO cardInfoToCardInfoDto(CardInfo cardInfo);
    CardInfo cardInfoDtoToCardInfo(CardInfoDTO cardInfoDto);

}
