package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.SeguroDTO;
import com.kusiyyasqa.app.models.entity.Seguro;
import com.kusiyyasqa.app.models.mapper.contracts.SeguroMapper;
import org.springframework.stereotype.Component;

@Component
public class SeguroMapperImpl implements SeguroMapper {
    @Override
    public Seguro fromDTO(SeguroDTO dto) {
        Seguro seguro = null;
        if(dto != null){
            seguro = new Seguro();
            seguro.setId(dto.getId());
            seguro.setTipo(dto.getTipo());
        }
        return seguro;
    }

    @Override
    public SeguroDTO toDTO(Seguro entity) {
        SeguroDTO seguro = null;
        if(entity != null){
            seguro = new SeguroDTO();
            seguro.setId(entity.getId());
            seguro.setTipo(entity.getTipo());
        }
        return seguro;
    }
}
