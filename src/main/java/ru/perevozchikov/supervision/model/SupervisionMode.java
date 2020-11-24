package ru.perevozchikov.supervision.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "supervisionModes")
@Data
public class SupervisionMode {
    @Id
    private String name;

    @Column(name = "resultOfEvent")
    private String resultOfEvent;

    @OneToMany(mappedBy = "supervisionMode")
    @JsonIgnore
    private List<Organization> organizations;
}
