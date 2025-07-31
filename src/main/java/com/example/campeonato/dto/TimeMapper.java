package com.example.campeonato.dto;

import com.example.campeonato.model.Time;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface TimeMapper {

    @Mapping(source = "estadio.id", target = "estadioId")
    TimeDTO toDTO(Time time);

    @Mapping(source = "estadioId", target = "estadio.id")
    Time toEntity(TimeDTO dto);
}
