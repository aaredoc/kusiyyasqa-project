package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.entity.Beneficiado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsistenciaDTO {
    private Long id;
    private Date fecha;
    private Boolean registro;
    private BeneficiadoDTO beneficiadoDTO;
}
