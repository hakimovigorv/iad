package com.itmo.iad.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "tasks")
public class Task {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "text")
    private String text;

    @Type(type = "text")
    private String title;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    private Set<Graph> graphs;

    @OneToMany(mappedBy = "task", cascade = CascadeType.REMOVE)
    private Set<News> news;
}
