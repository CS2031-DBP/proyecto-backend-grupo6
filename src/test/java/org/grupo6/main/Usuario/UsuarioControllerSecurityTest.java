package org.grupo6.main.Usuario;

import org.grupo6.main.Usuario.DTO.UsuarioDTO;
import org.grupo6.main.Usuario.Domain.Usuario;
import org.grupo6.main.Usuario.Domain.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.grupo6.main.Usuario.Infrastructure.UsuarioRepository;


import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerSecurityTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Usuario1");
        usuario.setEmail("usuario1@example.com");

        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setNombre("Usuario1");
        usuarioDTO.setEmail("usuario1@example.com");
    }

    @Test
    void testCreateUsuario() {
        UsuarioDTO newUsuarioDTO = new UsuarioDTO(null, "NuevoUsuario", "nuevousuario@example.com", "newpass", "newuser");
        Usuario newUsuario = new Usuario("NuevoUsuario", "nuevousuario@example.com", "newpass", "newuser");
        newUsuario.setId(1L);

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(newUsuario);
        UsuarioDTO createdUsuarioDTO = usuarioService.createUsuario(newUsuarioDTO);

        assertNotNull(createdUsuarioDTO);
        assertEquals("NuevoUsuario", createdUsuarioDTO.getNombre());
        assertEquals("nuevousuario@example.com", createdUsuarioDTO.getEmail());
    }

    @Test
    void testGetUsuarioById() {
        Usuario usuario = new Usuario("Usuario1", "usuario1@example.com", "password", "user1");
        usuario.setId(1L);
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        UsuarioDTO foundUsuarioDTO = usuarioService.getUsuarioById(1L);

        assertNotNull(foundUsuarioDTO);
        assertEquals(1L, foundUsuarioDTO.getId());
        assertEquals("Usuario1", foundUsuarioDTO.getNombre());
        assertEquals("usuario1@example.com", foundUsuarioDTO.getEmail());
    }

    @Test
    void testUpdateUsuario() {
        // Arrange
        Long userId = 1L;
        UsuarioDTO usuarioDTO = new UsuarioDTO(userId, "UsuarioActualizado", "usuarioactualizado@example.com", "newPassword", "newUsername");
        Usuario existingUsuario = new Usuario("UsuarioExistente", "usuarioexistente@example.com", "oldPassword", "oldUsername");
        existingUsuario.setId(userId);

        // Simula que el usuario existente está presente en la base de datos
        when(usuarioRepository.findById(userId)).thenReturn(Optional.of(existingUsuario));
        // Simula la operación de guardar actualizando el usuario y retorna el usuario simulado actualizado
        when(usuarioRepository.save(any(Usuario.class))).thenAnswer(invocation -> invocation.getArgument(0));

        // Act
        UsuarioDTO updatedUsuarioDTO = usuarioService.updateUsuario(userId, usuarioDTO);

        // Assert
        assertNotNull(updatedUsuarioDTO);
        assertEquals(userId, updatedUsuarioDTO.getId());
        assertEquals("UsuarioActualizado", updatedUsuarioDTO.getNombre());
        assertEquals("usuarioactualizado@example.com", updatedUsuarioDTO.getEmail());
        assertEquals("newPassword", updatedUsuarioDTO.getPassword());
        assertEquals("newUsername", updatedUsuarioDTO.getUsername());

        // Verifica que el método findById() del repositorio se haya llamado una vez con el ID correcto
        verify(usuarioRepository, times(1)).findById(userId);
        // Verifica que el método save() del repositorio se haya llamado una vez con el usuario actualizado
        verify(usuarioRepository, times(1)).save(existingUsuario);
    }
    @Test
    void testDeleteUsuario() {
        // Given
        Usuario usuario = new Usuario(1L, "Usuario1", "usuario1@example.com");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        // Act
        usuarioService.deleteUsuario(1L);

        // Assert
        verify(usuarioRepository, times(1)).delete(usuario);
    }

    @Test
    void testGetAllUsuarios() {
        // Given
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L, "Usuario1", "usuario1@example.com"));
        usuarios.add(new Usuario(2L, "Usuario2", "usuario2@example.com"));

        // Mock the behavior of findAll to return the list of users
        when(usuarioRepository.findAll()).thenReturn(usuarios);

        // Act
        List<UsuarioDTO> usuarioDTOList = usuarioService.getAllUsuarios();

        // Assert
        assertNotNull(usuarioDTOList);
        assertEquals(2, usuarioDTOList.size());
    }
}


