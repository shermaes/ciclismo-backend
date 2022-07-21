package com.sofka.ciclismo.router.equipo;

import com.sofka.ciclismo.usecase.equipo.DeleteEquipoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteEquipoRoute {
    @Bean
    RouterFunction<ServerResponse> deleteEquipo(DeleteEquipoUseCase useCase){
        return route(
                DELETE("/api/delete/equipo/{id}"),
                request -> ServerResponse.accepted()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.
                                fromPublisher(useCase.
                                        apply(request.pathVariable("id")), Void.class)));
    }


}
