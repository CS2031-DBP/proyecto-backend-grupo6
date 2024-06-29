package org.grupo6.main.Reserva.application;

import org.grupo6.main.Reserva.DTO.ReservaDTO;
import org.grupo6.main.Reserva.Domain.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<ReservaDTO> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @PostMapping
    public ReservaDTO createReserva(@RequestBody ReservaDTO reservaDTO) {
        return reservaService.createReserva(reservaDTO);
    }

    @GetMapping("/{id}")
    public ReservaDTO getReservaById(@PathVariable Long id) {
        return reservaService.getReservaById(id);
    }

    @PutMapping("/{id}")
    public ReservaDTO updateReserva(@PathVariable Long id, @RequestBody ReservaDTO reservaDTO) {
        return reservaService.updateReserva(id, reservaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.noContent().build();
    }
}