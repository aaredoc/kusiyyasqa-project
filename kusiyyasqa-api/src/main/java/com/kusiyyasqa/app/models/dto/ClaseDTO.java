package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.entity.Docente;
import com.kusiyyasqa.app.models.entity.Turno;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClaseDTO {
    private Long id;
    private String tipo;
    private String descripcion;
    private DocenteDTO docenteDTO;
    private TurnoDTO turnoDTO;
}
