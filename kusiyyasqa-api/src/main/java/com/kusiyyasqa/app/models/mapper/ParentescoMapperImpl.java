package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.ParentescoDTO;
import com.kusiyyasqa.app.models.entity.Parentesco;
import com.kusiyyasqa.app.models.mapper.contracts.ParentescoMapper;
import org.springframework.stereotype.Component;

@Component
public class ParentescoMapperImpl implements ParentescoMapper {
    @Override
    public Parentesco fromDTO(ParentescoDTO dto) {
        Parentesco parentesco = null;
        if(dto != null){
            parentesco = new Parentesco();
            parentesco.setId(dto.getId());
            parentesco.setNombre(dto.getNombre());
        }
        return parentesco;
    }

    @Override
    public ParentescoDTO toDTO(Parentesco entity) {
        ParentescoDTO parentesco = null;
        if(entity != null){
            parentesco = new ParentescoDTO();
            parentesco.setId(entity.getId());
            parentesco.setNombre(entity.getNombre());
        }
        return parentesco;
    }
}
