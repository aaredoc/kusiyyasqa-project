package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.entity.Administrador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioDTO {
    private Long id;
    private String titulo;
    private Date fecha;
    private String descripcion;
}
