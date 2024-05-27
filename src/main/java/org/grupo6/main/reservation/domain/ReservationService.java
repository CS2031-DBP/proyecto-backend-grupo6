package org.grupo6.main.reservation.domain;


import org.grupo6.main.exceptions.ReservationNotFoundException;
import org.grupo6.main.reservation.dto.ReservationDto;
import org.grupo6.main.reservation.infrastructure.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationDto> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ReservationDto createReservation(ReservationDto reservationDto) {
        Reservation reservation = new Reservation();
        reservation.setUser(reservationDto.getUser());
        reservation.setRestaurant(reservationDto.getRestaurant());
        reservation.setFechaHora(reservationDto.getFechaHora());
        reservation.setEstado(reservationDto.getEstado());
        reservationRepository.save(reservation);
        return convertToDto(reservation);
    }

    public ReservationDto getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation no encontrada"));
        return convertToDto(reservation);
    }

    public ReservationDto updateReservation(Long id, ReservationDto reservationDto) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation no encontrada"));
        reservation.setUser(reservationDto.getUser());
        reservation.setRestaurant(reservationDto.getRestaurant());
        reservation.setFechaHora(reservationDto.getFechaHora());
        reservation.setEstado(reservationDto.getEstado());
        reservationRepository.save(reservation);
        return convertToDto(reservation);
    }

    public void deleteReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException("Reservation no encontrada"));
        reservationRepository.delete(reservation);
    }

    private ReservationDto convertToDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setUser(reservation.getUser());
        reservationDto.setRestaurant(reservation.getRestaurant());
        reservationDto.setFechaHora(reservation.getFechaHora());
        reservationDto.setEstado(reservation.getEstado());
        return reservationDto;
    }
}
