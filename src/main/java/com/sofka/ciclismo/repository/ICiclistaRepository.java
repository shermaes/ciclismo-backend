package com.sofka.ciclismo.repository;

import com.sofka.ciclismo.collection.Ciclista;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ICiclistaRepository extends ReactiveMongoRepository<Ciclista, String> {
}
