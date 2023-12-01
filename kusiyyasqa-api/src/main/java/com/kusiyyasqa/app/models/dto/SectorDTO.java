package com.kusiyyasqa.app.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SectorDTO {
    private Long id;
    private String nombre;
    private ZonaDTO zona;
}
