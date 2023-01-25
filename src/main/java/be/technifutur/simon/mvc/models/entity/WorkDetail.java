package be.technifutur.simon.mvc.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "work_detail")
public class WorkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "date_start")
    private LocalDate dateStart;

    @Column(name = "date_end")
    private LocalDate dateEnd;

    @ManyToOne
    @JoinColumn(name = "employee_work_details")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "hotel_work_details")
    private Hotel hotel;
}