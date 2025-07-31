package com.example.campeonato.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @ManyToOne
    @JoinColumn(name = "estadio_id")
    private Estadio estadio;

    @OneToMany(mappedBy = "time")
    private List<Jogador> jogadores;
}
