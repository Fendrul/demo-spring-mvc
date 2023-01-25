package be.technifutur.simon.mvc.models.entity;

import be.technifutur.simon.mvc.models.entity.enums.RoomType;
import be.technifutur.simon.mvc.models.entity.enums.RoomView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "room_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int etage;

    @Column(name = "simple_bed")
    private int simpleBed;

    @Column(name = "double_bed")
    private int doubleBed;

    @Column(nullable = false)
    private int size;

    @Column(name = "additionnal_bed")
    private String additionnalBed;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_view", nullable = false)
    private RoomView room;

    private boolean avalaible;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RoomType type;

    @Column(columnDefinition = "NUMERIC(1)", nullable = false)
    private int stars;

    @OneToMany(mappedBy = "rooms")
    private List<Reservation> roomReservations;

    @ManyToOne
    @JoinColumn(name = "hotel_rooms")
    private Hotel hotel;
}
