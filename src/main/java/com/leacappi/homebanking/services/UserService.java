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

    public List<UserDto> getUsers() {
        List<User> users = repository.findAll();
        //List<User> users = usersDto.stream().map(UserMapper::dtoMapToUser).toList();
        //return users;
        return users.stream()
                .map(UserMapper::userMapToDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        Optional<User> user = repository.findById(id);
        UserDto userDto = UserMapper.userMapToDto(user.get());
        return userDto;
    }

    public UserDto createUser(UserDto dto){
        User user = UserMapper.dtoMapToUser(dto);

        return UserMapper.userMapToDto(repository.save(user));
    }
}
