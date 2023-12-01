package com.kusiyyasqa.app.models.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoDTO {
    private Long id;
    private Date fechaEmision;
    private String horasCertificadas;
}
