package com.itmo.iad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "news")
public class News {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    Timestamp date;

    @Type(type = "text")
    String text;
    @Type(type = "text")
    String title;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "task_id")
    private Task task;

}
