package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.NacionalidadDTO;
import com.kusiyyasqa.app.models.entity.Nacionalidad;
import com.kusiyyasqa.app.models.mapper.contracts.NacionalidadMapper;
import org.springframework.stereotype.Component;

@Component
public class NacionalidadMapperImpl implements NacionalidadMapper {
    @Override
    public Nacionalidad fromDTO(NacionalidadDTO dto) {
        Nacionalidad nacionalidad = null;
        if(dto != null){
            nacionalidad = new Nacionalidad();
            nacionalidad.setId(dto.getId());
            nacionalidad.setNombre(dto.getNombre());
        }
        return nacionalidad;
    }

    @Override
    public NacionalidadDTO toDTO(Nacionalidad entity) {
        NacionalidadDTO nacionalidad = null;
        if(entity != null){
            nacionalidad = new NacionalidadDTO();
            nacionalidad.setId(entity.getId());
            nacionalidad.setNombre(entity.getNombre());
        }
        return nacionalidad;
    }
}
