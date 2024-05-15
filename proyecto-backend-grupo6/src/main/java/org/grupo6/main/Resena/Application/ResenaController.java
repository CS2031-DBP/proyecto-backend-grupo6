package org.grupo6.main.Resena.Application;

import org.grupo6.main.Resena.Application.dto.ResenaDTO;
import org.grupo6.main.Resena.Domain.ResenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resenas")
public class ResenaController {

    private final ResenaService resenaService;

    @Autowired
    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @PostMapping
    public ResponseEntity<ResenaDTO> crearResena(@RequestBody ResenaDTO resenaDTO) {
        ResenaDTO nuevaResena = resenaService.crearResena(resenaDTO);
        return new ResponseEntity<>(nuevaResena, HttpStatus.CREATED);
    }

    // Otros métodos para actualizar, eliminar y obtener reseñas
}