package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.entity.Administrador;
import com.kusiyyasqa.app.models.entity.Certificado;
import com.kusiyyasqa.app.models.entity.Voluntario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParticipacionDTO {
    private Long id;
    private Date fechaInicio;
    private Date fechaFin;
    private CertificadoDTO certificadoDTO;
}
