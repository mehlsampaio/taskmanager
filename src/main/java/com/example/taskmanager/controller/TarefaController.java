package com.example.taskmanager.controller;

import com.example.taskmanager.business.TarefaService;
import com.example.taskmanager.infrastructure.entity.Tarefa;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/tarefas"})
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Operation(summary = "Criar Tarefa")
    @PostMapping
    public ResponseEntity<Void> salvarTarefa(@RequestBody @Valid Tarefa tarefa){
        tarefaService.salvarTarefa(tarefa);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Busca tarefas por id")
    @GetMapping
    public ResponseEntity<Tarefa> buscarTarefaPorId(@RequestParam long id){
        return ResponseEntity.ok(tarefaService.buscarTarefaPorId(id));
    }

    @Operation(summary = "Deleta tarefas por id")
    @DeleteMapping
    public ResponseEntity<Void> deletarTarefaPorId(@RequestParam long id) {
        tarefaService.deletarTarefaPorId(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Atualiza tarefa")
    @PutMapping
    public ResponseEntity<Void> atualizarTarefaPorId(@RequestParam long id, @RequestBody Tarefa tarefa) {
        tarefaService.atualizarTarefaPorId(id, tarefa);
        return ResponseEntity.ok().build();
    }
}
