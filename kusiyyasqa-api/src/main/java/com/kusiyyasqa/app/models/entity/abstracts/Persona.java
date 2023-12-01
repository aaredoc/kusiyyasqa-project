package com.kusiyyasqa.app.models.entity.abstracts;

import com.kusiyyasqa.app.models.entity.Nacionalidad;
import com.kusiyyasqa.app.models.entity.Sector;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class Persona extends DatosGenerales{



    @Column(nullable = false)
    private String fechaNacimiento;

    @Column(nullable = false)
    private String direccion;

    @ManyToOne
    private Nacionalidad nacionalidad;

    @ManyToOne
    private Sector sector;
}
