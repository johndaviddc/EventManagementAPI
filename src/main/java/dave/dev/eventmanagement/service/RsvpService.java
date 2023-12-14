package dave.dev.eventmanagement.service;

import dave.dev.eventmanagement.model.Rsvp;

import java.util.List;

public interface RsvpService {
    Rsvp createRsvp(Rsvp rsvp);
    Rsvp getRsvpById(Long rsvpId);
    List<Rsvp> getAllRsvps();
    Rsvp updateRsvp(Long rsvpId, Rsvp updatedRsvp);
    void deleteRsvp(Long rsvpId);
}
