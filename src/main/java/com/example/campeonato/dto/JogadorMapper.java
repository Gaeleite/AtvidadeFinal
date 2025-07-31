package com.example.campeonato.dto;

import com.example.campeonato.model.Jogador;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface JogadorMapper {

    @Mapping(source = "time.id", target = "timeId")
    JogadorDTO toDTO(Jogador jogador);

    @Mapping(source = "timeId", target = "time.id")
    Jogador toEntity(JogadorDTO dto);
}
