package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.ParticipacionDTO;
import com.kusiyyasqa.app.models.entity.Participacion;
import com.kusiyyasqa.app.models.mapper.contracts.CertificadoMapper;
import com.kusiyyasqa.app.models.mapper.contracts.ParticipacionMapper;
import com.kusiyyasqa.app.models.mapper.contracts.VoluntarioMapper;
import org.springframework.stereotype.Component;

@Component
public class ParticipacionMapperImpl implements ParticipacionMapper {

    private final CertificadoMapper certificadoMapper;

    public ParticipacionMapperImpl(CertificadoMapper certificadoMapper) {
        this.certificadoMapper = certificadoMapper;
    }

    @Override
    public Participacion fromDTO(ParticipacionDTO dto) {
        Participacion participacion = null;
        if(dto != null){
            participacion = new Participacion();
            participacion.setId(dto.getId());
            participacion.setFechaFin(dto.getFechaFin());
            participacion.setFechaInicio(dto.getFechaInicio());
            participacion.setCertificado(certificadoMapper.fromDTO(dto.getCertificadoDTO()));
        }
        return participacion;
    }

    @Override
    public ParticipacionDTO toDTO(Participacion entity) {
        ParticipacionDTO participacion = null;
        if(entity != null){
            participacion = new ParticipacionDTO();
            participacion.setId(entity.getId());
            participacion.setFechaFin(entity.getFechaFin());
            participacion.setFechaInicio(entity.getFechaInicio());
            participacion.setCertificadoDTO(certificadoMapper.toDTO(entity.getCertificado()));
        }
        return participacion;
    }
}
