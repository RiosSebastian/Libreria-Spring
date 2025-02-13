package com.example.springboottema4.servis;

import com.example.springboottema4.dto.UserDtoRes;
import com.example.springboottema4.dto.req.UserDtoReq;

import java.util.List;

public interface UserServis {

    public UserDtoRes getUser(Long id);

    UserDtoRes createUser(UserDtoReq userDTOReq);

    // Firma del método para obtener un usuario por su ID
    UserDtoRes getUserById(Long id);

    // Firma del método para actualizar un usuario
    UserDtoRes updateUser(Long id, UserDtoReq userDTOReq);

    // Firma del método para eliminar un usuario por su ID
    void deleteUser(Long id);

    // Firma del método para obtener todos los usuarios
    List<UserDtoRes> getAllUsers();

    UserDtoRes updateProfileImage(Long id, String imageUrl);
}
