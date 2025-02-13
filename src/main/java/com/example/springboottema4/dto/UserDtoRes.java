package com.example.springboottema4.dto;

import lombok.Builder;

@Builder
public record UserDtoRes(Long id,
                         String usuario,
                         String email,
                         String nombre,
                         String apellido,
                         String city,
                         String codigo_postal,
                         String telefono,
                         String userEnum){
}
