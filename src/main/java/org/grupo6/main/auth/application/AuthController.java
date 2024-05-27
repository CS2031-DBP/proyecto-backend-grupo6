package org.grupo6.main.auth.application;


import org.grupo6.main.auth.DTO.JwtAuthResponse;
import org.grupo6.main.auth.DTO.LoginReq;
import org.grupo6.main.auth.DTO.RegisterReq;
import org.grupo6.main.auth.exception.UserAlreadyExistException;
import org.grupo6.main.user.domain.User;
import org.grupo6.main.user.infrastructure.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterReq registerReq) {
        if (usuarioRepository.existsByUsername(registerReq.getUsername())) {
            throw new UserAlreadyExistException("Username is already taken");
        }
        User usuario = new User();
        usuario.setUsername(registerReq.getUsername());
        usuario.setPassword(passwordEncoder.encode(registerReq.getPassword()));
        usuario.setEmail(registerReq.getEmail());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginReq loginReq) {
        // El manejo del login se hace a través de JwtAuthenticationFilter
        return ResponseEntity.ok(new JwtAuthResponse("Login successful"));
    }
}