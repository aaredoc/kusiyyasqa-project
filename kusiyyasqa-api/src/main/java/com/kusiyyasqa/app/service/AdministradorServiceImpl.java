package com.kusiyyasqa.app.service;

import com.kusiyyasqa.app.models.dto.AdministradorDTO;
import com.kusiyyasqa.app.models.entity.Administrador;
import com.kusiyyasqa.app.models.mapper.contracts.AdministradorMapper;
import com.kusiyyasqa.app.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdministradorServiceImpl implements AdministradorService, UserDetailsService {

    private final AdministradorRepository administradorRepository;
    private final AdministradorMapper administradorMapper;

    @Autowired
    public AdministradorServiceImpl(AdministradorRepository administradorRepository, AdministradorMapper administradorMapper){
        this.administradorRepository = administradorRepository;
        this.administradorMapper = administradorMapper;
    }

    @Override
    public List<AdministradorDTO> findAll() {
        return this.administradorRepository.findAll()
                .stream()
                .map(this.administradorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdministradorDTO findById(Long id) {
        return this.administradorMapper.toDTO(this.administradorRepository.findById(id).orElse(null));
    }

    @Override
    public AdministradorDTO save(AdministradorDTO dto) {
        return this.administradorMapper.toDTO(administradorRepository.save(this.administradorMapper.fromDTO(dto)));
    }

    @Override
    public AdministradorDTO update(AdministradorDTO dto) {
        boolean exists = this.administradorRepository.existsById(dto.getId());
        if(!exists){
            return null;
        }
        return this.administradorMapper.toDTO(this.administradorRepository.save(this.administradorMapper.fromDTO(dto)));
    }

    @Override
    public void delete(Long id) {
        boolean exists = this.administradorRepository.existsById(id);
        if(exists){
           this.administradorRepository.deleteById(id);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrador administrador = administradorRepository.findByUsername(username);
        List<GrantedAuthority>authorities = administrador.getRoles().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList());
        return new User(administrador.getUsername(), administrador.getPassword(), administrador.isEnabled(), true, true, true, authorities);
    }
}
