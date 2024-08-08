package com.nemo.modul9homework7.repository;

import com.nemo.modul9homework7.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByCompletedFalse();
}

