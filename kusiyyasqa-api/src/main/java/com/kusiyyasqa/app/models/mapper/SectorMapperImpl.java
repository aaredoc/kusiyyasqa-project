package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.SectorDTO;
import com.kusiyyasqa.app.models.entity.Sector;
import com.kusiyyasqa.app.models.mapper.contracts.SectorMapper;
import com.kusiyyasqa.app.models.mapper.contracts.ZonaMapper;
import org.springframework.stereotype.Component;

@Component
public class SectorMapperImpl implements SectorMapper {

    private final ZonaMapper zonaMapper;

    public SectorMapperImpl(ZonaMapper zonaMapper) {
        this.zonaMapper = zonaMapper;
    }

    @Override
    public Sector fromDTO(SectorDTO dto) {
        Sector sector = null;
        if(dto != null){
            sector = new Sector();
            sector.setId(dto.getId());
            sector.setNombre(dto.getNombre());
            sector.setZona(zonaMapper.fromDTO(dto.getZona()));
        }
        return sector;
    }

    @Override
    public SectorDTO toDTO(Sector entity) {
        SectorDTO sector = null;
        if(entity != null){
            sector = new SectorDTO();
            sector.setId(entity.getId());
            sector.setNombre(entity.getNombre());
            sector.setZona(zonaMapper.toDTO(entity.getZona()));
        }
        return sector;
    }
}
