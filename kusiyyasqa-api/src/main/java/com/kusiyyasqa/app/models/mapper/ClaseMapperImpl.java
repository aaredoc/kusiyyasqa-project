package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.ClaseDTO;
import com.kusiyyasqa.app.models.entity.Clase;
import com.kusiyyasqa.app.models.mapper.contracts.ClaseMapper;
import com.kusiyyasqa.app.models.mapper.contracts.TurnoMapper;
import org.springframework.stereotype.Component;

@Component
public class ClaseMapperImpl implements ClaseMapper {

    private final TurnoMapper turnoMapper;

    public ClaseMapperImpl(TurnoMapper turnoMapper) {
        this.turnoMapper = turnoMapper;
    }

    @Override
    public Clase fromDTO(ClaseDTO dto) {
        Clase clase = null;
        if(dto != null){
           clase = new Clase();
           clase.setId(dto.getId());
           clase.setTipo(dto.getTipo());
           clase.setTurno(turnoMapper.fromDTO(dto.getTurnoDTO()));
           clase.setDescripcion(dto.getDescripcion());
        }
        return clase;
    }

    @Override
    public ClaseDTO toDTO(Clase entity) {
        ClaseDTO clase = null;
        if(entity != null){
            clase = new ClaseDTO();
            clase.setId(entity.getId());
            clase.setTipo(entity.getTipo());
            clase.setTurnoDTO(turnoMapper.toDTO(entity.getTurno()));
            clase.setDescripcion(entity.getDescripcion());
        }
        return clase;
    }
}
