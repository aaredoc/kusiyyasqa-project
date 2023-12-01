package com.kusiyyasqa.app.repository;

import com.kusiyyasqa.app.models.entity.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
}
