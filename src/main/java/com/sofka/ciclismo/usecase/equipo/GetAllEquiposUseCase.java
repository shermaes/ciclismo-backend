package com.sofka.ciclismo.usecase.equipo;

import com.sofka.ciclismo.dto.EquipoDTO;
import com.sofka.ciclismo.mapper.CiclismoMapper;
import com.sofka.ciclismo.repository.IEquipoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllEquiposUseCase {
    private IEquipoRepository repo;
    private CiclismoMapper mapper;

    public GetAllEquiposUseCase(IEquipoRepository repo, CiclismoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }
    public Flux<EquipoDTO> apply(){return repo.findAll().map(mapper::toEquipoDTO);}
}