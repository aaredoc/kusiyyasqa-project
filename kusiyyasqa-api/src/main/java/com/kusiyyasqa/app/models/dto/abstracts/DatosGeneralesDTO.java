package com.kusiyyasqa.app.models.dto.abstracts;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class DatosGeneralesDTO {
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String celular;
    private String email;
    private String identificacion;
}
