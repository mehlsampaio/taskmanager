package io.github.mehlsampaio.taskmanager.service;

import io.github.mehlsampaio.taskmanager.entity.Tarefa;
import io.github.mehlsampaio.taskmanager.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvarTarefa(Tarefa tarefa) {
        return tarefaRepository.saveAndFlush(tarefa);
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

    public Tarefa atualizarTarefaPorId(long id, Tarefa tarefa) {
        Tarefa tarefa1 = buscarTarefaPorId(id);
        Tarefa tarefaAtualizada = Tarefa.builder()
                .nome(tarefa.getNome() != null ?
                        tarefa.getNome() : tarefa1.getNome())
                .dataEntrega(tarefa.getDataEntrega() != null ?
                        tarefa.getDataEntrega() : tarefa1.getDataEntrega())
                .responsavel(tarefa.getResponsavel() != null ?
                        tarefa.getResponsavel() : tarefa1.getResponsavel())
                .prioridade(tarefa.getPrioridade() != null ?
                        tarefa.getPrioridade() : tarefa1.getPrioridade())
                .statusTarefa(tarefa.getStatusTarefa() != null ?
                        tarefa.getStatusTarefa() : tarefa1.getStatusTarefa())
                .id(tarefa1.getId())
                .build();
        return tarefaRepository.saveAndFlush(tarefaAtualizada);
    }
}
