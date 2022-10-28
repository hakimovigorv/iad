package com.itmo.iad.repository;

import com.itmo.iad.model.Graph;
import com.itmo.iad.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraphRepository extends JpaRepository<Graph, Long> {
}

