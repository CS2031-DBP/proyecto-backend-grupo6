package org.grupo6.main.user.application;

import org.grupo6.main.user.domain.UserService;
import org.grupo6.main.user.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getAllUsuarios() {
        return userService.getAllUsers();
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto UserDto) {
        return userService.createUser(UserDto);
    }
/*
    @GetMapping("/{id}")
    public UserDto getUsuarioById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUsuario(@PathVariable Long id, @RequestBody UserDto UserDto) {
        return userService.updateUsuario(id, UserDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        userService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }*/
}
