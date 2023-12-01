package com.kusiyyasqa.app.repository;

import com.kusiyyasqa.app.models.entity.Donativo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonativoRepository extends JpaRepository<Donativo, Long> {
}
