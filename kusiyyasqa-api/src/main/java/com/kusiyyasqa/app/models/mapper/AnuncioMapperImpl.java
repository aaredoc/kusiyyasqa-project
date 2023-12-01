package com.kusiyyasqa.app.models.mapper;

import com.kusiyyasqa.app.models.dto.AnuncioDTO;
import com.kusiyyasqa.app.models.entity.Anuncio;
import com.kusiyyasqa.app.models.mapper.contracts.AnuncioMapper;
import com.kusiyyasqa.app.models.mapper.contracts.MapperClass;
import org.springframework.stereotype.Component;

@Component
public class AnuncioMapperImpl implements AnuncioMapper{
    @Override
    public Anuncio fromDTO(AnuncioDTO dto) {
        Anuncio anuncio = null;
        if(dto != null){
            anuncio = new Anuncio();
            anuncio.setId(dto.getId());
            anuncio.setTitulo(dto.getTitulo());
            anuncio.setFecha(dto.getFecha());
            anuncio.setDescripcion(dto.getDescripcion());
        }
        return anuncio;
    }

    @Override
    public AnuncioDTO toDTO(Anuncio entity) {
        AnuncioDTO anuncio = null;
        if(entity != null){
            anuncio = new AnuncioDTO();
            anuncio.setId(entity.getId());
            anuncio.setTitulo(entity.getTitulo());
            anuncio.setFecha(entity.getFecha());
            anuncio.setDescripcion(entity.getDescripcion());
        }
        return anuncio;
    }
}
