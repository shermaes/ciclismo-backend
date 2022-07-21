package com.sofka.ciclismo.usecase.ciclista;

import com.sofka.ciclismo.dto.CiclistaDTO;
import com.sofka.ciclismo.mapper.CiclismoMapper;
import com.sofka.ciclismo.repository.ICiclistaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetCiclistaByNacionalidadUseCase {
    private ICiclistaRepository repo;
    private CiclismoMapper mapper;

    public GetCiclistaByNacionalidadUseCase(ICiclistaRepository repo, CiclismoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Flux<CiclistaDTO> getCiclistaByNacionalidad(String nacionalidad){
        return repo.findByNacionalidad(nacionalidad).map(mapper::toCiclistaDTO)
                .switchIfEmpty(Mono.error(() -> new Exception("No se encontro ningun ciclista de esa nacionalidad")));
    }
}
