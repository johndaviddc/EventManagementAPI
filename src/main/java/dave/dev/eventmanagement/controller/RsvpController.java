package dave.dev.eventmanagement.controller;

import dave.dev.eventmanagement.model.Rsvp;
import dave.dev.eventmanagement.service.RsvpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
