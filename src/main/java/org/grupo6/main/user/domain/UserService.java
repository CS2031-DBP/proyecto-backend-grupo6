package org.grupo6.main.user.domain;

import org.grupo6.main.user.dto.UserDto;
import org.grupo6.main.user.infrastructure.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    public List<UserDto> getAllUsers() {
        List<User> Users = userRepository.findAll();
        return Users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public UserDto createUser(UserDto UserDto) {
        User User = new User();
        User.setNombre(UserDto.getNombre());
        User.setEmail(UserDto.getEmail());
        userRepository.save(User);
        return convertToDto(User);
    }
/*
    public UserDto getUserById(Long id) {
        User User = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User no encontrado"));
        return convertToDto(User);
    }

    public UserDto updateUser(Long id, UserDto UserDto) {
        User User = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User no encontrado"));
        User.setNombre(UserDto.getNombre());
        User.setEmail(UserDto.getEmail());
        userRepository.save(User);
        return convertToDto(User);
    }

    public void deleteUser(Long id) {
        User User = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User no encontrado"));
        userRepository.delete(User);
    }
*/
    private UserDto convertToDto(User User) {
        UserDto UserDto = new UserDto();
        UserDto.setId(User.getId());
        UserDto.setNombre(User.getNombre());
        UserDto.setEmail(User.getEmail());
        return UserDto;
    }
}