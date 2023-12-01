package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.AsistenciaDTO;
import com.kusiyyasqa.app.models.entity.Asistencia;
import com.kusiyyasqa.app.models.mapper.contracts.AsistenciaMapper;
import com.kusiyyasqa.app.models.mapper.contracts.BeneficiadoMapper;
import org.springframework.stereotype.Component;

@Component
public class AsistenciaMapperImpl implements AsistenciaMapper {

    private final BeneficiadoMapper beneficiadoMapper;

    public AsistenciaMapperImpl(BeneficiadoMapper beneficiadoMapper) {
        this.beneficiadoMapper = beneficiadoMapper;
    }

    @Override
    public Asistencia fromDTO(AsistenciaDTO dto) {
        Asistencia asistencia = null;
        if(dto != null){
            asistencia = new Asistencia();
            asistencia.setId(dto.getId());
            asistencia.setRegistro(dto.getRegistro());
            asistencia.setFecha(dto.getFecha());
            asistencia.setBeneficiado(beneficiadoMapper.fromDTO(dto.getBeneficiadoDTO()));
        }
        return asistencia;
    }

    @Override
    public AsistenciaDTO toDTO(Asistencia entity) {
        AsistenciaDTO asistencia = null;
        if(entity != null){
            asistencia = new AsistenciaDTO();
            asistencia.setId(entity.getId());
            asistencia.setRegistro(entity.getRegistro());
            asistencia.setFecha(entity.getFecha());
            asistencia.setBeneficiadoDTO(beneficiadoMapper.toDTO(entity.getBeneficiado()));
        }
        return asistencia;
    }
}
