package com.sofka.ciclismo.usecase.ciclista;

import com.sofka.ciclismo.dto.CiclistaDTO;
import com.sofka.ciclismo.dto.EquipoDTO;
import com.sofka.ciclismo.mapper.CiclismoMapper;
import com.sofka.ciclismo.repository.ICiclistaRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class PutCiclistaUseCase {

    private ICiclistaRepository repo;
    private CiclismoMapper mapper;

    public PutCiclistaUseCase(ICiclistaRepository repo, CiclismoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Mono<CiclistaDTO> apply(CiclistaDTO dto){
        return repo
                .save(mapper.toCiclista(dto))
                .map(mapper::toCiclistaDTO);}
}
