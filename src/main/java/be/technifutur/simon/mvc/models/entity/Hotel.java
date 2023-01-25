package be.technifutur.simon.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.IndexColumn;
import org.springframework.context.annotation.EnableMBeanExport;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Getter @Setter
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id", nullable = false)
    private Long id;

    @Column(name = "stars", scale = 1)
    private int stars;

    @OneToOne
    @JoinColumn(name = "receptionnist_id")
    private Employee receptionnist;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

//    @Column(name = "employees")
//    private List<Employee> employees;

    @OneToMany(mappedBy = "hotel")
    private List<Room> hotelRooms;

    @OneToMany(mappedBy = "hotel")
    private List<Employee> employees;

    @OneToMany(mappedBy = "hotel")
    private List<WorkDetail> hotelWorkDetails;
}
