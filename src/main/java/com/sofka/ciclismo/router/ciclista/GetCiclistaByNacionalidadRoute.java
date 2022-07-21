package com.sofka.ciclismo.router.ciclista;

import com.sofka.ciclismo.dto.CiclistaDTO;
import com.sofka.ciclismo.usecase.ciclista.GetCiclistaByNacionalidadUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetCiclistaByNacionalidadRoute {

    @Bean
    public RouterFunction<ServerResponse> getCyclistsByCountry(GetCiclistaByNacionalidadUseCase useCase) {
        return route(GET("/api/ciclista/{nacionalidad}"),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.getCiclistaByNacionalidad(request.pathVariable("nacionalidad")),
                                CiclistaDTO.class))
                        .onErrorResume(throwable -> ServerResponse.notFound().build()));
    }
}
