package org.grupo6.main.Ubicacion.Application;
import org.grupo6.main.Ubicacion.Domain.Ubicacion;
import org.grupo6.main.Ubicacion.Domain.UbicacionService;
import org.grupo6.main.Ubicacion.DTO.UbicacionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicaciones")
public class UbicacionController {

    private final UbicacionService ubicacionService;

    @Autowired
    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;
    }

    @GetMapping
    public List<UbicacionDTO> buscarExperienciasPorUbicacionTipoCocinaYPrecio(
            @RequestParam(required = false) String ubicacion,
            @RequestParam(required = false) String tipoCocina,
            @RequestParam(required = false) String precio) {
        return ubicacionService.buscarExperienciasPorUbicacionTipoCocinaYPrecio(ubicacion, tipoCocina, precio);
    }
}