package io.github.mehlsampaio.taskmanager.repository;

import io.github.mehlsampaio.taskmanager.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository <Tarefa, Long> {
}
