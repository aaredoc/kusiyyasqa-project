package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.CertificadoDTO;
import com.kusiyyasqa.app.models.entity.Certificado;
import com.kusiyyasqa.app.models.mapper.contracts.CertificadoMapper;
import org.springframework.stereotype.Component;

@Component
public class CertificadoMapperImpl implements CertificadoMapper {
    @Override
    public Certificado fromDTO(CertificadoDTO dto) {
        Certificado certificado = null;
        if(dto != null){
            certificado = new Certificado();
            certificado.setId(dto.getId());
            certificado.setFechaEmision(dto.getFechaEmision());
            certificado.setHorasCertificadas(dto.getHorasCertificadas());
        }
        return certificado;
    }

    @Override
    public CertificadoDTO toDTO(Certificado entity) {
        CertificadoDTO certificado = null;
        if(entity != null){
            certificado = new CertificadoDTO();
            certificado.setId(entity.getId());
            certificado.setFechaEmision(entity.getFechaEmision());
            certificado.setHorasCertificadas(entity.getHorasCertificadas());
        }
        return certificado;
    }
}
