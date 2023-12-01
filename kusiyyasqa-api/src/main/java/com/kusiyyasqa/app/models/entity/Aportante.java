package com.kusiyyasqa.app.models.entity;

import com.kusiyyasqa.app.models.entity.abstracts.DatosGenerales;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "aportante")
public class Aportante extends DatosGenerales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ruc;
}
