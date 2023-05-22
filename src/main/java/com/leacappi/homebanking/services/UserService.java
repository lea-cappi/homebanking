package com.leacappi.homebanking.services;

import com.leacappi.homebanking.mappers.UserMapper;
import com.leacappi.homebanking.models.User;
import com.leacappi.homebanking.models.dtos.UserDto;
import com.leacappi.homebanking.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //Dependency injection by annotation
    @Autowired
    private final UserRepository repository;

    //Dependency injection by constructor;
    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getUsers() {
        List<UserDto> usersDto = repository.findAll();
        //List<User> users = usersDto.stream().map(UserMapper::dtoMapToUser).toList();
        //return users;
        return usersDto.stream()
                .map(UserMapper::dtoMapToUser)
                .toList();
    }

    public User getUserById(Long id) {
        Optional<UserDto> userDto = (UserDto) repository.findById(id);
        User user = UserMapper.dtoMapToUser(userDto);
        return user;
    }

    public User createUser(User user){
        UserDto dto = UserMapper.userMapToDto(user);

        return UserMapper.dtoMapToUser(repository.save(dto));
    }
}
