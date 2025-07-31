package com.example.campeonato.controller;

import com.example.campeonato.dto.JogadorDTO;
import com.example.campeonato.dto.JogadorMapper;
import com.example.campeonato.model.Jogador;
import com.example.campeonato.service.JogadorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService service;
    private final JogadorMapper mapper;

    public JogadorController(JogadorService service, JogadorMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public Page<JogadorDTO> findAll(Pageable pageable) {
        return service.findAll(pageable).map(mapper::toDTO);
    }

    @GetMapping("/{id}")
    public JogadorDTO findById(@PathVariable Integer id) {
        return service.findById(id).map(mapper::toDTO).orElse(null);
    }

    @PostMapping
    public JogadorDTO create(@RequestBody JogadorDTO dto) {
        Jogador jogador = mapper.toEntity(dto);
        return mapper.toDTO(service.save(jogador));
    }

    @PutMapping("/{id}")
    public JogadorDTO update(@PathVariable Integer id, @RequestBody JogadorDTO dto) {
        Jogador jogador = mapper.toEntity(dto);
        return mapper.toDTO(service.update(id, jogador));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
