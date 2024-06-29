package org.grupo6.main.Evento.application;

import org.grupo6.main.Evento.DTO.EventoDTO;
import org.grupo6.main.Evento.domain.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public List<EventoDTO> getAllEventos() {
        return eventoService.getAllEventos();
    }

    @PostMapping
    public EventoDTO createEvento(@RequestBody EventoDTO eventoDTO) {
        return eventoService.createEvento(eventoDTO);
    }

    @GetMapping("/{id}")
    public EventoDTO getEventoById(@PathVariable Long id) {
        return eventoService.getEventoById(id);
    }

    @PutMapping("/{id}")
    public EventoDTO updateEvento(@PathVariable Long id, @RequestBody EventoDTO eventoDTO) {
        return eventoService.updateEvento(id, eventoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvento(@PathVariable Long id) {
        eventoService.deleteEvento(id);
        return ResponseEntity.noContent().build();
    }
}