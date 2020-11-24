package ru.perevozchikov.supervision.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "events")
@Data
public class Event {
    @Id
    private String name;

    @Column(name = "datetime")//, nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private LocalDateTime dateOfEvent;

    @Column(name = "resultOfEvent")//, nullable = false)
    private String resultOfEvent;

    @OneToMany(mappedBy = "event")
    @JsonIgnore
    private List<Organization> organizations;
//    @ManyToMany
//    @JoinTable(
//            name = "employee_event",
//            joinColumns = {@JoinColumn(name = "event_name")},
//            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
//    )
//    @JsonIgnoreProperties("events")
//    private List<Employee> employees;

}
