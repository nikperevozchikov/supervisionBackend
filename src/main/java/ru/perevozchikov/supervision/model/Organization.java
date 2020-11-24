package ru.perevozchikov.supervision.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "organizations")
@Data
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "organization_id_seq")
    @SequenceGenerator(name = "organization_id_seq")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "datetime", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime dateFoundation;

    @Column(name = "ogrn", nullable = false)
    private Long ogrn;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "event")
    private Event event;


    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "supervisionMode", nullable = false)
    private SupervisionMode supervisionMode;

}
