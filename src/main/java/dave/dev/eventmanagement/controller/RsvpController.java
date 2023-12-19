package dave.dev.eventmanagement.controller;

import dave.dev.eventmanagement.model.Rsvp;
import dave.dev.eventmanagement.service.RsvpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rsvps")
public class RsvpController {
    private final RsvpService rsvpService;

    @Autowired
    public RsvpController(RsvpService rsvpService) {
        this.rsvpService = rsvpService;
    }

    @PostMapping
    public ResponseEntity<Rsvp> createRsvp(@RequestBody Rsvp rsvp) {
        Rsvp createdRsvp = rsvpService.createRsvp(rsvp);
        return new ResponseEntity<>(createdRsvp, HttpStatus.CREATED);
    }

    @GetMapping("/{rsvpId}")
    public ResponseEntity<Rsvp> getRsvpById(@PathVariable Long rsvpId) {
        Rsvp rsvp = rsvpService.getRsvpById(rsvpId);
        return new ResponseEntity<>(rsvp, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Rsvp>> getAllRsvps() {
        List<Rsvp> rsvps = rsvpService.getAllRsvps();
        return new ResponseEntity<>(rsvps, HttpStatus.OK);
    }

    @PutMapping("/{rsvpId}")
    public ResponseEntity<Rsvp> updateRsvp(@PathVariable Long rsvpId, @RequestBody Rsvp updatedRsvp) {
        Rsvp rsvp = rsvpService.updateRsvp(rsvpId, updatedRsvp);
        return new ResponseEntity<>(rsvp, HttpStatus.OK);
    }

    @DeleteMapping("/{rsvpId}")
    public ResponseEntity<Void> deleteRsvp(@PathVariable Long rsvpId) {
        rsvpService.deleteRsvp(rsvpId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
