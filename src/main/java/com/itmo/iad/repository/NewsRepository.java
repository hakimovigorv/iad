package com.itmo.iad.repository;

import com.itmo.iad.model.News;
import com.itmo.iad.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
