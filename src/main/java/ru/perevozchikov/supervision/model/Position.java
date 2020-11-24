package ru.perevozchikov.supervision.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "positions")
@Data
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "position_id_seq")
    @SequenceGenerator(name = "position_id_seq")
    private int id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "position")
    @JsonIgnore
    private List<Employee> employees;

}
