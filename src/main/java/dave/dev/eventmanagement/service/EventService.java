package dave.dev.eventmanagement.service;

import dave.dev.eventmanagement.model.Event;

import java.util.List;

public interface EventService {
    Event createEvent(Event event);
    Event getEventById(Long eventId);
    List<Event> getAllEvents();
    Event updateEvent(Long eventId, Event updatedEvent);
    void deleteEvent(Long eventId);
}
