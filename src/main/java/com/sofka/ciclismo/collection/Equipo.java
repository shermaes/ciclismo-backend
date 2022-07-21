package com.sofka.ciclismo.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Document(collection="equipo")
public class Equipo {
    @Id
    private String id;
    @NotBlank
    private String nombre;
    @NotBlank
    @Size(max = 3)
    private String codigo;
    @NotBlank
    private String pais;
    private List<Ciclista> ciclistas;


}
