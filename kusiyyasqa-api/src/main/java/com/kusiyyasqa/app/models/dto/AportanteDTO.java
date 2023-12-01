package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.dto.abstracts.DatosGeneralesDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AportanteDTO extends DatosGeneralesDTO {
    private Long id;
    private String ruc;
}
