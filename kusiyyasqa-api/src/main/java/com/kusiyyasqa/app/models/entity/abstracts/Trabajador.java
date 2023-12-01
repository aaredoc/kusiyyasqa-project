package com.kusiyyasqa.app.models.entity.abstracts;


import com.kusiyyasqa.app.models.entity.Seguro;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public  abstract class Trabajador extends Persona{
    @Column(nullable = false)
    private String codigo;

    @ManyToOne
    private Seguro seguro;
}
