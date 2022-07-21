package com.sofka.ciclismo.router.ciclista;

import com.sofka.ciclismo.usecase.ciclista.DeleteCiclistaUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteCiclistaRoute {
    @Bean
    RouterFunction<ServerResponse> deleteCiclista(DeleteCiclistaUseCase useCase){
        return route(
                DELETE("/api/delete/ciclista/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.
                                fromPublisher(useCase.
                                        apply(request.pathVariable("id")), Void.class)));
    }

}
