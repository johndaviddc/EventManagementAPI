package dave.dev.eventmanagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rsvps")
public class Rsvp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
