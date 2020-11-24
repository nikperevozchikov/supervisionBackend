package ru.perevozchikov.supervision.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
public class Employee extends User {
    @Column(name = "address", nullable = false)
    private String registrationAddress;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd MMM yyyy")
    private LocalDate birthday;


    @ManyToOne
    @JoinColumn(nullable = false)
    private Position position;

//    @ManyToMany
//    @JoinTable(
//            name = "employee_event",
//            joinColumns = {@JoinColumn(name = "employee_id")},
//            inverseJoinColumns = {@JoinColumn(name = "event_name")}
//    )
//    @JsonIgnoreProperties("employees")
//    private List<Event> events;
}
