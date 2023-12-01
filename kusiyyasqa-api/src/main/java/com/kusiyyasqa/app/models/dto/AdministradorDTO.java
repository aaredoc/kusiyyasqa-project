package com.kusiyyasqa.app.models.dto;

import com.kusiyyasqa.app.models.dto.abstracts.TrabajadorDTO;
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
public class AdministradorDTO extends TrabajadorDTO {
    private Long id;
    private String username;
    private String password;
    private List<AnuncioDTO> anuncioDTOList = new ArrayList<>();
    private List<ParticipacionDTO>participacionDTOList = new ArrayList<>();
    private List<DonativoDTO>donativoDTOList = new ArrayList<>();
    private List<RoleDTO> roles;
    private boolean enabled;
}
