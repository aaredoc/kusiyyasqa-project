package com.kusiyyasqa.app.models.entity;

import com.kusiyyasqa.app.models.entity.abstracts.Trabajador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "administrador")
public class Administrador extends Trabajador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany
    private List<Anuncio> anuncioList = new ArrayList<>();

    @OneToMany
    private List<Participacion>participacionList = new ArrayList<>();

    @OneToMany
    private List<Donativo> donativoList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();

    private boolean enabled;
}
