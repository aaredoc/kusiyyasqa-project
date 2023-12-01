package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.dto.abstracts.PersonaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TutorDTO extends PersonaDTO {
    private Long id;
    private Boolean compromiso;
    private ParentescoDTO parentescoDTO;
}
