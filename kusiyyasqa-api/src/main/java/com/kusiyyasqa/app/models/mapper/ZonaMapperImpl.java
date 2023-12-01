package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.ZonaDTO;
import com.kusiyyasqa.app.models.entity.Zona;
import com.kusiyyasqa.app.models.mapper.contracts.ZonaMapper;
import org.springframework.stereotype.Component;

@Component
public class ZonaMapperImpl implements ZonaMapper {
    @Override
    public Zona fromDTO(ZonaDTO dto) {
        Zona zona = null;
        if(dto != null){
            zona = new Zona();
            zona.setId(dto.getId());
            zona.setNombre(dto.getNombre());
        }
        return zona;
    }

    @Override
    public ZonaDTO toDTO(Zona entity) {
        ZonaDTO zona = null;
        if(entity != null){
            zona = new ZonaDTO();
            zona.setId(entity.getId());
            zona.setNombre(entity.getNombre());
        }
        return zona;
    }
}
