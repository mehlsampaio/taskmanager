package com.example.taskmanager.business;

import com.example.taskmanager.infrastructure.entity.Tarefa;
import com.example.taskmanager.infrastructure.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public void salvarTarefa(Tarefa tarefa) {
        tarefaRepository.saveAndFlush(tarefa);
    }

    public Tarefa buscarTarefaPorId(long id) {
        return tarefaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Tarefa não encontrada.")
        );
    }

    public void deletarTarefaPorId(long id) {
        buscarTarefaPorId(id);
        tarefaRepository.deleteById(id);
    }

    public void atualizarTarefaPorId(long id, Tarefa tarefa) {
        Tarefa tarefa1 = buscarTarefaPorId(id);
        Tarefa tarefaAtualizada = Tarefa.builder()
                .nome(tarefa.getNome() != null ?
                        tarefa.getNome() : tarefa1.getNome())
                .dataEntrega(tarefa.getDataEntrega() != null ?
                        tarefa.getDataEntrega() : tarefa1.getDataEntrega())
                .responsavel(tarefa.getResponsavel() != null ?
                        tarefa.getResponsavel() : tarefa1.getResponsavel())
                .id(tarefa1.getId())
                .build();
        tarefaRepository.saveAndFlush(tarefaAtualizada);
    }

}
