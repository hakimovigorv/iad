package com.itmo.iad.model.exam;

import com.itmo.iad.model.Graph;
import com.itmo.iad.model.News;
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
@Table(name = "exam_tasks")
public class ExamTask {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Type(type = "text")
    private String text;

    @Type(type = "text")
    private String title;

    private Integer answer;

    @OneToMany(mappedBy = "examTask", cascade = CascadeType.REMOVE)
    private Set<ExamGraph> examGraphs;

    @OneToMany(mappedBy = "examTask", cascade = CascadeType.REMOVE)
    private Set<ExamNews> examNews;
}
