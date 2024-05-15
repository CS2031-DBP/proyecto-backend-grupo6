package org.grupo6.main.Usuario;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.grupo6.main.dto.UsuarioCreateDTO;
import org.grupo6.main.dto.UsuarioDTO;
import org.grupo6.main.dto.UsuarioUpdateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerSecurityTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testGetAllUsuariosWithAdminRole() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        // Aquí puedes agregar más aserciones según las respuestas esperadas
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testGetAllUsuariosWithUserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testCreateUsuarioWithAdminRole() throws Exception {
        UsuarioCreateDTO usuarioDTO = new UsuarioCreateDTO();
        usuarioDTO.setNombre("Nombre");
        usuarioDTO.setApellido("Apellido");
        usuarioDTO.setEmail("email@example.com");
        usuarioDTO.setPassword("password");
        usuarioDTO.setTelefono("123456789");

        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .content(asJsonString(usuarioDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testCreateUsuarioWithUserRole() throws Exception {
        UsuarioCreateDTO usuarioDTO = new UsuarioCreateDTO();
        usuarioDTO.setNombre("Nombre");
        usuarioDTO.setApellido("Apellido");
        usuarioDTO.setEmail("email@example.com");
        usuarioDTO.setPassword("password");
        usuarioDTO.setTelefono("123456789");

        mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .content(asJsonString(usuarioDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testUpdateUsuarioWithAdminRole() throws Exception {
        UsuarioUpdateDTO usuarioDTO = new UsuarioUpdateDTO();
        usuarioDTO.setNombre("Nuevo Nombre");
        usuarioDTO.setApellido("Nuevo Apellido");
        usuarioDTO.setEmail("nuevo_email@example.com");
        usuarioDTO.setTelefono("987654321");

        mockMvc.perform(MockMvcRequestBuilders.put("/usuarios/1")
                        .content(asJsonString(usuarioDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testUpdateUsuarioWithUserRole() throws Exception {
        UsuarioUpdateDTO usuarioDTO = new UsuarioUpdateDTO();
        usuarioDTO.setNombre("Nuevo Nombre");
        usuarioDTO.setApellido("Nuevo Apellido");
        usuarioDTO.setEmail("nuevo_email@example.com");
        usuarioDTO.setTelefono("987654321");

        mockMvc.perform(MockMvcRequestBuilders.put("/usuarios/1")
                        .content(asJsonString(usuarioDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    public void testDeleteUsuarioWithAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    public void testDeleteUsuarioWithUserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    public void testGetUsuarioById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUsuarioByIdNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/usuarios/999")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // Método para convertir un objeto Java a JSON
    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
