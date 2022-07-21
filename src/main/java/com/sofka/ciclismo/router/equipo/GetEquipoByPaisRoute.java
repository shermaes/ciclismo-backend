package com.sofka.ciclismo.router.equipo;

import com.sofka.ciclismo.dto.EquipoDTO;
import com.sofka.ciclismo.usecase.equipo.GetEquipoByPaisUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetEquipoByPaisRoute {

    @Bean
    public RouterFunction<ServerResponse> getEquipoByPais(GetEquipoByPaisUseCase useCase){
        return route(GET("/api/equipo/{pais}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.getEquipoByPais(request.pathVariable("pais")),
                                EquipoDTO.class))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }
}
