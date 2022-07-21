package com.sofka.ciclismo.router.equipo;
import com.sofka.ciclismo.dto.EquipoDTO;
import com.sofka.ciclismo.usecase.equipo.PostEquipoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostEquipoRoute {

    @Bean
    public RouterFunction<ServerResponse> postEquipo(PostEquipoUseCase useCase) {
        return route(POST("/api/post/equipo").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(EquipoDTO.class)
                        .flatMap(equipoDTO -> useCase.apply(equipoDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
