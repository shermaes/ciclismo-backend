package com.sofka.ciclismo.usecase.equipo;

import com.sofka.ciclismo.dto.EquipoDTO;
import com.sofka.ciclismo.mapper.CiclismoMapper;
import com.sofka.ciclismo.repository.IEquipoRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class PutEquipoUseCase {
    private IEquipoRepository repo;
    private CiclismoMapper mapper;

    public PutEquipoUseCase(IEquipoRepository repo, CiclismoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Mono<EquipoDTO> apply(EquipoDTO dto){
        return repo
                .save(mapper.toEquipo(dto))
                .map(mapper::toEquipoDTO);}

}
