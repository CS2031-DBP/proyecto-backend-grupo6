package org.grupo6.main.Promocion.domain;


import org.grupo6.main.Exception.PromocionNotFoundException;
import org.grupo6.main.Promocion.DTO.PromocionDTO;
import org.grupo6.main.Promocion.Infrastructure.PromocionRepository;
import org.grupo6.main.Restaurante.domain.Restaurante;
import org.grupo6.main.Restaurante.infrastructure.RestauranteRepository;
import org.grupo6.main.Usuario.Domain.Usuario;
import org.grupo6.main.Usuario.Infrastructure.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromocionService {

    @Autowired
    private PromocionRepository promocionRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<PromocionDTO> getAllPromociones() {
        List<Promocion> promociones = promocionRepository.findAll();
        return promociones.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public PromocionDTO createPromocion(PromocionDTO promocionDTO) {
        Promocion promocion = new Promocion();
        promocion.setDescripcion(promocionDTO.getDescripcion());
        promocion.setFechaInicio(promocionDTO.getFechaInicio());
        promocion.setFechaFin(promocionDTO.getFechaFin());

        List<Long> restauranteIds = promocionDTO.getRestauranteIds() != null ? promocionDTO.getRestauranteIds() : new ArrayList<>();
        List<Long> usuarioIds = promocionDTO.getUsuarioIds() != null ? promocionDTO.getUsuarioIds() : new ArrayList<>();

        List<Restaurante> restaurantes = restauranteRepository.findAllById(restauranteIds);
        promocion.setRestaurantes(restaurantes);

        List<Usuario> usuarios = usuarioRepository.findAllById(usuarioIds);
        promocion.setUsuarios(usuarios);

        promocionRepository.save(promocion);
        return convertToDTO(promocion);
    }

    public PromocionDTO getPromocionById(Long id) {
        Promocion promocion = promocionRepository.findById(id)
                .orElseThrow(() -> new PromocionNotFoundException("Promoción no encontrada"));
        return convertToDTO(promocion);
    }

    public PromocionDTO updatePromocion(Long id, PromocionDTO promocionDTO) {
        Promocion promocion = promocionRepository.findById(id)
                .orElseThrow(() -> new PromocionNotFoundException("Promoción no encontrada"));

        promocion.setDescripcion(promocionDTO.getDescripcion());
        promocion.setFechaInicio(promocionDTO.getFechaInicio());
        promocion.setFechaFin(promocionDTO.getFechaFin());

        List<Long> restauranteIds = promocionDTO.getRestauranteIds() != null ? promocionDTO.getRestauranteIds() : new ArrayList<>();
        List<Long> usuarioIds = promocionDTO.getUsuarioIds() != null ? promocionDTO.getUsuarioIds() : new ArrayList<>();

        List<Restaurante> restaurantes = restauranteRepository.findAllById(restauranteIds);
        promocion.setRestaurantes(restaurantes);

        List<Usuario> usuarios = usuarioRepository.findAllById(usuarioIds);
        promocion.setUsuarios(usuarios);

        promocionRepository.save(promocion);
        return convertToDTO(promocion);
    }

    public void deletePromocion(Long id) {
        Promocion promocion = promocionRepository.findById(id)
                .orElseThrow(() -> new PromocionNotFoundException("Promoción no encontrada"));
        promocionRepository.delete(promocion);
    }

    private PromocionDTO convertToDTO(Promocion promocion) {
        PromocionDTO promocionDTO = new PromocionDTO();
        promocionDTO.setId(promocion.getId());
        promocionDTO.setDescripcion(promocion.getDescripcion());
        promocionDTO.setFechaInicio(promocion.getFechaInicio());
        promocionDTO.setFechaFin(promocion.getFechaFin());
        promocionDTO.setRestauranteIds(promocion.getRestaurantes() != null ?
                promocion.getRestaurantes().stream().map(Restaurante::getId).collect(Collectors.toList()) : new ArrayList<>());
        promocionDTO.setUsuarioIds(promocion.getUsuarios() != null ?
                promocion.getUsuarios().stream().map(Usuario::getId).collect(Collectors.toList()) : new ArrayList<>());
        return promocionDTO;
    }
}