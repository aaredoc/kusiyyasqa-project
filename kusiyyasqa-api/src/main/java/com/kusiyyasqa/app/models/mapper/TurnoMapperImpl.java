package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.TurnoDTO;
import com.kusiyyasqa.app.models.entity.Turno;
import com.kusiyyasqa.app.models.mapper.contracts.TurnoMapper;
import org.springframework.stereotype.Component;

@Component
public class TurnoMapperImpl implements TurnoMapper {
    @Override
    public Turno fromDTO(TurnoDTO dto) {
        Turno turno = null;
        if(dto != null){
            turno = new Turno();
            turno.setId(dto.getId());
            turno.setTipo(dto.getTipo());
            turno.setDescripcion(dto.getDescripcion());
        }
        return turno;
    }

    @Override
    public TurnoDTO toDTO(Turno entity) {
        TurnoDTO turno = null;
        if(entity != null){
            turno = new TurnoDTO();
            turno.setId(entity.getId());
            turno.setTipo(entity.getTipo());
            turno.setDescripcion(entity.getDescripcion());
        }
        return turno;
    }
}
