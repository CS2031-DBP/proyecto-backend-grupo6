package org.grupo6.main.Reserva.Domain;

import org.grupo6.main.Exception.ReservaNotFoundException;
import org.grupo6.main.Reserva.DTO.ReservaDTO;
import org.grupo6.main.Reserva.Infrastructure.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<ReservaDTO> getAllReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReservaDTO createReserva(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setUsuario(reservaDTO.getUsuario());
        reserva.setRestaurante(reservaDTO.getRestaurante());
        reserva.setFechaHora(reservaDTO.getFechaHora());
        reserva.setEstado(reservaDTO.getEstado());
        reservaRepository.save(reserva);
        return convertToDTO(reserva);
    }

    public ReservaDTO getReservaById(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException("Reserva no encontrada"));
        return convertToDTO(reserva);
    }

    public ReservaDTO updateReserva(Long id, ReservaDTO reservaDTO) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException("Reserva no encontrada"));
        reserva.setUsuario(reservaDTO.getUsuario());
        reserva.setRestaurante(reservaDTO.getRestaurante());
        reserva.setFechaHora(reservaDTO.getFechaHora());
        reserva.setEstado(reservaDTO.getEstado());
        reservaRepository.save(reserva);
        return convertToDTO(reserva);
    }

    public void deleteReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException("Reserva no encontrada"));
        reservaRepository.delete(reserva);
    }

    private ReservaDTO convertToDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setId(reserva.getId());
        reservaDTO.setUsuario(reserva.getUsuario());
        reservaDTO.setRestaurante(reserva.getRestaurante());
        reservaDTO.setFechaHora(reserva.getFechaHora());
        reservaDTO.setEstado(reserva.getEstado());
        return reservaDTO;
    }
}