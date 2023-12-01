package com.kusiyyasqa.app.repository;

import com.kusiyyasqa.app.models.entity.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Administrador findByUsername(String username);
}
