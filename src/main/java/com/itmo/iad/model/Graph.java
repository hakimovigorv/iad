package com.itmo.iad.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "graphs")
public class Graph {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Timestamp date;
    Double value;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "task_id")
    private Task task;
}
