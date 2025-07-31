package com.example.campeonato.service;

import com.example.campeonato.model.Jogador;
import com.example.campeonato.repository.JogadorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JogadorService {
    private final JogadorRepository repository;

    public JogadorService(JogadorRepository repository) {
        this.repository = repository;
    }

    public Page<Jogador> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Optional<Jogador> findById(Integer id) {
        return repository.findById(id);
    }

    public Jogador save(Jogador jogador) {
        return repository.save(jogador);
    }

    public Jogador update(Integer id, Jogador jogador) {
        jogador.setId(id);
        return repository.save(jogador);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
