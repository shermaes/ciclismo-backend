package com.sofka.ciclismo.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Document(collection="ciclista")
public class Ciclista {
    @Id
    private String id;
    @NotBlank
    private String nombre_completo;

    @Size(max = 3)
    private Integer numero;
    @NotBlank
    private String equipo;
    @NotBlank
    private String nacionalidad;
}
