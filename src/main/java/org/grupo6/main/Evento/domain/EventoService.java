package org.grupo6.main.Evento.domain;

import org.grupo6.main.Evento.DTO.EventoDTO;
import org.grupo6.main.Evento.Infrastructure.EventoRepository;
import org.grupo6.main.Exception.EventoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoService {
    @Autowired
    private EventoRepository eventoRepository;

    public List<EventoDTO> getAllEventos() {
        return eventoRepository.findAll().stream()
                .map(evento -> new EventoDTO(evento.getId(), evento.getRestaurante(), evento.getNombre(), evento.getFecha(), evento.getCapacidad()))
                .collect(Collectors.toList());
    }

    public EventoDTO createEvento(EventoDTO eventoDTO) {
        Evento evento = new Evento(null, eventoDTO.getRestaurante(), eventoDTO.getNombre(), eventoDTO.getFecha(), eventoDTO.getCapacidad());
        Evento savedEvento = eventoRepository.save(evento);
        eventoDTO.setId(savedEvento.getId()); // Asignar el ID al DTO
        return eventoDTO;
    }
    public EventoDTO getEventoById(Long id) {
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        return new EventoDTO(evento.getId(), evento.getRestaurante(), evento.getNombre(), evento.getFecha(), evento.getCapacidad());
    }

    public EventoDTO updateEvento(Long id, EventoDTO eventoDTO) {
        Evento evento = eventoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        evento.setNombre(eventoDTO.getNombre());
        evento.setFecha(eventoDTO.getFecha());
        evento.setCapacidad(eventoDTO.getCapacidad());
        Evento updatedEvento = eventoRepository.save(evento);
        eventoDTO.setId(updatedEvento.getId()); // Asignar el ID actualizado al DTO
        return eventoDTO;
    }
    public void deleteEvento(Long id) {
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        eventoRepository.delete(evento);
    }
}