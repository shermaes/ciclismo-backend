package com.sofka.ciclismo.dto;
import com.sofka.ciclismo.collection.Ciclista;
import lombok.Data;
import java.util.List;

@Data
public class EquipoDTO {

    private String id;
    private String nombre;
    private String codigo;
    private String pais;
    private List<Ciclista> ciclistas;
}
