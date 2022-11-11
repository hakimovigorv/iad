package com.itmo.iad.model.exam;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itmo.iad.model.Task;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "exam_graphs")
public class ExamGraph {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Timestamp date;
    Double value;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "exam_task_id")
    private ExamTask examTask;

}
