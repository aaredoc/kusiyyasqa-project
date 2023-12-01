package com.kusiyyasqa.app.models.dto.abstracts;

import com.kusiyyasqa.app.models.dto.SeguroDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TrabajadorDTO extends PersonaDTO{
    private String codigo;
    private SeguroDTO seguroDTO;
}
