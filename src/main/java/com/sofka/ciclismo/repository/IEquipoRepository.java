package com.sofka.ciclismo.repository;

import com.sofka.ciclismo.collection.Equipo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IEquipoRepository extends ReactiveMongoRepository<Equipo, String> {
}
