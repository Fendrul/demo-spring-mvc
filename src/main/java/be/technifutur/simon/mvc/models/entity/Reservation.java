package be.technifutur.simon.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "`reservation`")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @Column(name = "date_cancellation")
    private LocalDate dateCancellation;

    @Column(name = "with_additional_bed")
    private int withAdditionalBed;

    private int price;

    private int discount;

    @Column(name = "breakfast_included")
    private boolean breakfastIncluded;

    @Column(name = "date_begin")
    private LocalDate dateBegin;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "user_reservations")
    private User users;

    @ManyToOne
    @JoinColumn(name = "room_reservations")
    private Room rooms;
}
