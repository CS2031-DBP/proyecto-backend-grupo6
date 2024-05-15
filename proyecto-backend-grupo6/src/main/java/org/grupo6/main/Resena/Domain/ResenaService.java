package org.grupo6.main.Resena.Domain;
import org.grupo6.main.Resena.Application.dto.ReseñaDTO;
import org.grupo6.main.Resena.DTO.ResenaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenaService {

    private final ResenaMapper resenaMapper;

    @Autowired
    public ResenaService(ResenaMapper resenaMapper) {
        this.resenaMapper = resenaMapper;
    }

    public ResenaDTO crearResena(ResenaDTO resenaDTO) {
        // Aquí iría la lógica para crear una reseña en la base de datos
        // Puedes utilizar el mapper para convertir ResenaDTO a Resena y viceversa
        // Luego, guardar la reseña en la base de datos y devolver la reseña creada
        return resenaDTO;
    }
}