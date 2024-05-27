package org.grupo6.main.event.domain;

import org.grupo6.main.event.dto.EventDto;
import org.grupo6.main.event.infrastructure.EventRepository;
import org.grupo6.main.exceptions.EventNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class EventService {


    @Autowired
    private EventRepository eventRepository;

    public List<EventDto> getAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public EventDto createEvent(EventDto eventDto) {
        Event event = new Event();
        event.setRestaurant(eventDto.getRestaurant());
        event.setNombre(eventDto.getNombre());
        event.setFechaHora(eventDto.getFecha());
        event.setCapacidad(eventDto.getCapacidad());
        eventRepository.save(event);
        return convertToDto(event);
    }

    public EventDto getEventById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event no encontrado"));
        return convertToDto(event);
    }

    public EventDto updateEvent(Long id, EventDto eventDto) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event no encontrado"));
        event.setRestaurant(eventDto.getRestaurant());
        event.setNombre(eventDto.getNombre());
        event.setFechaHora(eventDto.getFecha());
        event.setCapacidad(eventDto.getCapacidad());
        eventRepository.save(event);
        return convertToDto(event);
    }

    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException("Event no encontrado"));
        eventRepository.delete(event);
    }

    private EventDto convertToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setRestaurant(event.getRestaurant());
        eventDto.setNombre(event.getNombre());
        eventDto.setFecha(event.getFechaHora());
        eventDto.setCapacidad(event.getCapacidad());
        return eventDto;
    }
}
