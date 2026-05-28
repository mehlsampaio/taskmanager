package com.example.taskmanager.infrastructure.repository;

import com.example.taskmanager.infrastructure.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository <Tarefa, Long> {
}
