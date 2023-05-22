package com.leacappi.homebanking.mappers;

import com.leacappi.homebanking.models.User;
import com.leacappi.homebanking.models.dtos.UserDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {
    //Allows to send data bidirectional with dto

    public UserDto userMapToDto(User user) {
        UserDto dto = new UserDto();
        dto.setUsername(user.getUsername());
        dto.setPassword(user.getPassword());
        dto.setId(user.getId());

        return dto;
    }

    public User dtoMapToUser(UserDto dto){
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setId(dto.getId());

        return user;
    }
}
