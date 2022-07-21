package com.sofka.ciclismo.repository;

import com.sofka.ciclismo.collection.Equipo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface IEquipoRepository extends ReactiveMongoRepository<Equipo, String> {
    //I'll need to add a method here to look for teams by the pais needed
    Flux<Equipo> findByPais(String pais);
}
