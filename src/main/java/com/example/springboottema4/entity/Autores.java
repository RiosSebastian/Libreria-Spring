package com.example.springboottema4.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autores {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String fechaNacimiento;
    private String nacionalidad;

    @Column(length = 2000)
    private String biografia;

    private String generoLiterario;

    @OneToMany(mappedBy = "autor")
    private List<Libros> librosEscritos;

    private String premios;
    private String fotoUrl;
    private String fechaFallecimiento;
    private String redesSociales;
}
