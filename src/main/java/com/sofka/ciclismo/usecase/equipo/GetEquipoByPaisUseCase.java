package com.sofka.ciclismo.usecase.equipo;

import com.sofka.ciclismo.dto.EquipoDTO;
import com.sofka.ciclismo.mapper.CiclismoMapper;
import com.sofka.ciclismo.repository.IEquipoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetEquipoByPaisUseCase {

    private IEquipoRepository repo;
    private CiclismoMapper mapper;

    public GetEquipoByPaisUseCase(IEquipoRepository repo, CiclismoMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Flux<EquipoDTO> getEquipoByPais(String pais){
        return repo.findByPais(pais).map(mapper::toEquipoDTO)
                .switchIfEmpty(Mono.error(() -> new Exception("No se encontro ningun equipo con el pais dado")));
    }
}
