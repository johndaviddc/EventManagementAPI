package dave.dev.eventmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rsvps")
public class Rsvp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(nullable = false)
    private String attendeeName;

    @Column(nullable = false)
    private boolean attending;

    public Rsvp(Long id, Event event, String attendeeName, boolean attending) {
        this.id = id;
        this.event = event;
        this.attendeeName = attendeeName;
        this.attending = attending;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getAttendeeName() {
        return attendeeName;
    }

    public void setAttendeeName(String attendeeName) {
        this.attendeeName = attendeeName;
    }

    public boolean isAttending() {
        return attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }
}
