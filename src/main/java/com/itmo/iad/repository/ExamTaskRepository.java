package com.itmo.iad.repository;

import com.itmo.iad.model.exam.ExamTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamTaskRepository extends JpaRepository<ExamTask, Long> {
}
