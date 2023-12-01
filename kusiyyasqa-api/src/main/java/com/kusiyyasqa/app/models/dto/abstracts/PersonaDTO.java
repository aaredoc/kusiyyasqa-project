package com.kusiyyasqa.app.models.dto.abstracts;

import com.kusiyyasqa.app.models.dto.NacionalidadDTO;
import com.kusiyyasqa.app.models.dto.SectorDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PersonaDTO extends DatosGeneralesDTO {
    private String fechaNacimiento;
    private String direccion;
    private NacionalidadDTO nacionalidad;
    private SectorDTO sector;
}
