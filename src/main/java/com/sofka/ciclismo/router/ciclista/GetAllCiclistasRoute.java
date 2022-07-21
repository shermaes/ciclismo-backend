package com.sofka.ciclismo.router.ciclista;

import com.sofka.ciclismo.dto.CiclistaDTO;
import com.sofka.ciclismo.usecase.ciclista.GetAllCiclistasUseCase;
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
public class GetAllCiclistasRoute {

    @Bean
    public RouterFunction<ServerResponse> allCiclistas(GetAllCiclistasUseCase get) {
        return route(GET("/api/get/ciclistas"),
                request -> ServerResponse.status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(get.apply(), CiclistaDTO.class))
        );
    }

}
