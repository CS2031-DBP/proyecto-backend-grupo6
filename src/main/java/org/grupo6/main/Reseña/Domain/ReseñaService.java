package org.grupo6.main.Reseña.Domain;

import org.grupo6.main.Exception.ReseñaNotFoundException;
import org.grupo6.main.Reseña.DTO.ReseñaDTO;
import org.grupo6.main.Reseña.Infrastructure.ReseñaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReseñaService {

    @Autowired
    private ReseñaRepository reseñaRepository;

    public List<ReseñaDTO> getAllReseñas() {
        List<Reseña> reseñas = reseñaRepository.findAll();
        return reseñas.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public ReseñaDTO createReseña(ReseñaDTO reseñaDTO) {
        Reseña reseña = new Reseña();
        reseña.setUsuario(reseñaDTO.getUsuario());
        reseña.setRestaurante(reseñaDTO.getRestaurante());
        reseña.setValoracion(reseñaDTO.getValoracion());
        reseña.setComentario(reseñaDTO.getComentario());
        reseñaRepository.save(reseña);
        return convertToDTO(reseña);
    }

    public ReseñaDTO getReseñaById(Long id) {
        Reseña reseña = reseñaRepository.findById(id)
                .orElseThrow(() -> new ReseñaNotFoundException("Reseña no encontrada"));
        return convertToDTO(reseña);
    }

    public ReseñaDTO updateReseña(Long id, ReseñaDTO reseñaDTO) {
        Reseña reseña = reseñaRepository.findById(id)
                .orElseThrow(() -> new ReseñaNotFoundException("Reseña no encontrada"));
        reseña.setUsuario(reseñaDTO.getUsuario());
        reseña.setRestaurante(reseñaDTO.getRestaurante());
        reseña.setValoracion(reseñaDTO.getValoracion());
        reseña.setComentario(reseñaDTO.getComentario());
        reseñaRepository.save(reseña);
        return convertToDTO(reseña);
    }

    public void deleteReseña(Long id) {
        Reseña reseña = reseñaRepository.findById(id)
                .orElseThrow(() -> new ReseñaNotFoundException("Reseña no encontrada"));
        reseñaRepository.delete(reseña);
    }

    private ReseñaDTO convertToDTO(Reseña reseña) {
        ReseñaDTO reseñaDTO = new ReseñaDTO();
        reseñaDTO.setId(reseña.getId());
        reseñaDTO.setUsuario(reseña.getUsuario());
        reseñaDTO.setRestaurante(reseña.getRestaurante());
        reseñaDTO.setValoracion(reseña.getValoracion());
        reseñaDTO.setComentario(reseña.getComentario());
        return reseñaDTO;
    }
}