package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.dto.abstracts.PersonaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoluntarioDTO extends PersonaDTO {
    private Long id;
    private List<ParticipacionDTO> participacionList = new ArrayList<>();
}
