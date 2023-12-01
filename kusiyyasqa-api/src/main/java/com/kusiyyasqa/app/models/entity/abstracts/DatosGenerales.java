package com.kusiyyasqa.app.models.entity.abstracts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class DatosGenerales {

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidoPaterno;

    @Column(nullable = false)
    private String apellidoMaterno;

    private String telefono;

    private String celular;

    private String email;

    @Column(nullable = false)
    private String identificacion;
}
