package com.sofka.ciclismo.usecase.ciclista;

import com.sofka.ciclismo.dto.CiclistaDTO;
import com.sofka.ciclismo.mapper.CiclismoMapper;
import com.sofka.ciclismo.repository.ICiclistaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllCiclistasUseCase {
    private ICiclistaRepository repo;
    private CiclismoMapper mapper;

    public GetAllCiclistasUseCase(ICiclistaRepository repo, CiclismoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Flux<CiclistaDTO> apply(){return repo.findAll().map(mapper::toCiclistaDTO);}
}


