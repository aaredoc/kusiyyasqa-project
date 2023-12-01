package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.entity.Administrador;
import com.kusiyyasqa.app.models.entity.Aportante;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DonativoDTO {
    private Long id;
    private BigDecimal monto;
    private Date fecha;
    private String descripcion;
    private AportanteDTO aportanteDTO;
}
