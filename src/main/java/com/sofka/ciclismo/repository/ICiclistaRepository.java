package com.sofka.ciclismo.repository;

import com.sofka.ciclismo.collection.Ciclista;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ICiclistaRepository extends ReactiveMongoRepository<Ciclista, String> {

    Flux<Ciclista> findByNacionalidad(String nacionalidad);
}
