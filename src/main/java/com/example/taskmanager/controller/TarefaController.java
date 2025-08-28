package com.example.taskmanager.controller;

import com.example.taskmanager.model.Tarefa;
import com.example.taskmanager.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tarefas"})
public class TarefaController {

    private TarefaRepository repository;

    TarefaController(TarefaRepository tarefaRepository){
        this.repository = tarefaRepository;

    }

    @GetMapping
    public List<?> findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<?> findById(@PathVariable long id){
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record)) .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public Tarefa create(@RequestBody Tarefa tarefa){
        return repository.save(tarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> update(@PathVariable("id") long id, @RequestBody Tarefa tarefa){
        return repository.findById(id).map(record -> {
            record.setNome(tarefa.getNome());
            record.setDataEntrega(tarefa.getDataEntrega());
            record.setResponsavel(tarefa.getResponsavel());
            Tarefa updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete(@PathVariable long id){
        return repository.findById(id).map(record ->{
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

}
