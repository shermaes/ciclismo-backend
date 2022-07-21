package com.sofka.ciclismo.mapper;

import com.sofka.ciclismo.collection.Ciclista;
import com.sofka.ciclismo.collection.Equipo;
import com.sofka.ciclismo.dto.CiclistaDTO;
import com.sofka.ciclismo.dto.EquipoDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
@RequiredArgsConstructor
public class CiclismoMapper {

    private final ModelMapper modelMapper = new ModelMapper();

    public EquipoDTO toEquipoDTO(Equipo equipo) {
        return modelMapper.map(equipo, EquipoDTO.class);
    }

    public Equipo toEquipo(EquipoDTO  dto) {
        return modelMapper.map(dto,Equipo.class );
    }

    public CiclistaDTO toCiclistaDTO(Ciclista ciclista) {
        return modelMapper.map(ciclista, CiclistaDTO.class);
    }

    public Ciclista toCiclista(CiclistaDTO  dto) {
        return modelMapper.map(dto,Ciclista.class );
    }
}
