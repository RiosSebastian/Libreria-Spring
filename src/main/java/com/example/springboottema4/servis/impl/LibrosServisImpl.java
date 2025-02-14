package com.example.springboottema4.servis.impl;

import com.example.springboottema4.entity.Libros;
import com.example.springboottema4.repository.LibrosRepository;
import com.example.springboottema4.servis.LibrosServis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LibrosServisImpl implements LibrosServis {

    @Autowired
    private LibrosRepository librosRepository;
    @Override
    public Libros guardarLibros(Libros nombre_libro) {
         return librosRepository.save(nombre_libro);
    }

    @Override
    public List<Libros> BuscarListaDeLibros() {
        return (List<Libros>) librosRepository.findAll();
    }

    @Override
    public List<Libros> BuscarListaDeLibros(Long id) {
        return null;
    }

    @Override
    public Libros actualizarLibros(Libros libros, Long id) {
        return null;
    }

    @Override
    public void deletelibrosByid(long id) {
        librosRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }
}
