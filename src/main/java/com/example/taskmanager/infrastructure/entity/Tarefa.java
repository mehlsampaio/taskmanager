package com.example.taskmanager.infrastructure.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tarefa")
@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome não pode ser nulo.")
    @Size(max = 60, message = "O campo nome deve conter no máximo 60 caracteres.")
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotNull(message = "O campo dataEntrega não pode ser nulo.")
    @FutureOrPresent(message = "A data de entrega não pode ser no passado.")
    @Column(name = "data_entrega", nullable = false)
    private LocalDate dataEntrega;

    @NotBlank(message = "O campo responsavel não pode ser nulo.")
    @Size(max = 60, message = "O campo responsavel deve conter no máximo 60 caracteres.")
    @Column(name = "responsavel", nullable = false)
    private String responsavel;

}
