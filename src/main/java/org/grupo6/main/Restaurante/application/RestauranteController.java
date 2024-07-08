package org.grupo6.main.Restaurante.application;

import org.grupo6.main.Restaurante.DTO.RestauranteDTO;
import org.grupo6.main.Restaurante.domain.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public Page<RestauranteDTO> getRestaurantesPaginados(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "10") int size) {
        return restauranteService.getRestaurantesPaginados(page, size);
    }

    @PostMapping
    public RestauranteDTO createRestaurante(@RequestBody RestauranteDTO restauranteDTO) {
        return restauranteService.createRestaurante(restauranteDTO);
    }

    @GetMapping("/{id}")
    public RestauranteDTO getRestauranteById(@PathVariable Long id) {
        return restauranteService.getRestauranteById(id);
    }

    @PutMapping("/{id}")
    public RestauranteDTO updateRestaurante(@PathVariable Long id, @RequestBody RestauranteDTO restauranteDTO) {
        return restauranteService.updateRestaurante(id, restauranteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurante(@PathVariable Long id) {
        restauranteService.deleteRestaurante(id);
        return ResponseEntity.noContent().build();
    }
}
