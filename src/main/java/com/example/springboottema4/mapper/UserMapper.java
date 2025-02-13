package com.example.springboottema4.mapper;

import com.example.springboottema4.dto.UserDtoRes;
import com.example.springboottema4.dto.req.UserDtoReq;
import com.example.springboottema4.entity.Rol;
import com.example.springboottema4.entity.Usuario;

public class UserMapper {
    public static UserDtoRes toDTO(Usuario userEntity) {
        return UserDtoRes.builder()
                .id(userEntity.getId())
                .usuario(userEntity.getUsuario())
                .email(userEntity.getEmail())
                .apellido(userEntity.getApellido())
                .city(userEntity.getCity())
                .codigo_postal(userEntity.getCodigo_postal())
                .telefono(userEntity.getTelefono())
                .userEnum(userEntity.getUserEnum().toString())
               // .profileImage(userEntity.getProfileImage())
                .build();
    }

    public static Usuario toUserEntity(UserDtoReq request) {
        Rol userEnum = Rol.valueOf(request.userEnum());
        return Usuario.builder()
                .usuario(request.usuario())
                .email(request.email())
                .password(request.password())
                .userEnum(userEnum)
                .build();
    }
}
