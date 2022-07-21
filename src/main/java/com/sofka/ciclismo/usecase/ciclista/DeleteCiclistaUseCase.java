package com.sofka.ciclismo.usecase.ciclista;

import com.sofka.ciclismo.repository.ICiclistaRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteCiclistaUseCase {
    private ICiclistaRepository repo;

    public DeleteCiclistaUseCase(ICiclistaRepository repo) {
        this.repo = repo;
    }

    public Mono<Void> apply(String id) {
        return repo.deleteById(id);
    }
}
