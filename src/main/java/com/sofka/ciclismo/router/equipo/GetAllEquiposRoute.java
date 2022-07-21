package com.sofka.ciclismo.router.equipo;

import com.sofka.ciclismo.dto.EquipoDTO;
import com.sofka.ciclismo.usecase.equipo.GetAllEquiposUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllEquiposRoute {

    @Bean
    public RouterFunction<ServerResponse> allEquipos(GetAllEquiposUseCase get) {
        return route(GET("/api/get/equipos"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), EquipoDTO.class))
        );
    }
}
