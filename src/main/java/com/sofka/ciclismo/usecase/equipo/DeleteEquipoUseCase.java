package com.sofka.ciclismo.usecase.equipo;

import com.sofka.ciclismo.repository.IEquipoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteEquipoUseCase {

    private IEquipoRepository repo;

    public DeleteEquipoUseCase(IEquipoRepository repo) {
        this.repo = repo;
    }

    public Mono<Void> apply(String id) {
        return repo.deleteById(id);
    }
}
