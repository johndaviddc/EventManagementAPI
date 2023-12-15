package dave.dev.eventmanagement.service;

import dave.dev.eventmanagement.exception.RsvpNotFoundException;
import dave.dev.eventmanagement.model.Rsvp;
import dave.dev.eventmanagement.repository.RsvpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RsvpServiceImpl extends RsvpService {
    private final RsvpRepository rsvpRepository;

    @Autowired
    public RsvpServiceImpl(RsvpRepository rsvpRepository) {
        this.rsvpRepository = rsvpRepository;
    }

    @Override
    public Rsvp createRsvp(Rsvp rsvp) {
        return rsvpRepository.save(rsvp);
    }

    @Override
    public Rsvp getRsvpById(Long rsvpId) {
        return rsvpRepository.findById(rsvpId)
                .orElseThrow(() -> new RsvpNotFoundException("RSVP not found with id: " + rsvpId));
    }

    @Override
    public List<Rsvp> getAllRsvps() {
        return rsvpRepository.findAll();
    }

    @Override
    public Rsvp updateRsvp(Long rsvpId, Rsvp updatedRsvp) {
        Rsvp existingRsvp = getRsvpById(rsvpId);
        // Add any additional business logic for updating
        existingRsvp.setAttendeeName(updatedRsvp.getAttendeeName());
        existingRsvp.setAttending(updatedRsvp.isAttending());
        // Update other fields as needed
        return rsvpRepository.save(existingRsvp);
    }
}
