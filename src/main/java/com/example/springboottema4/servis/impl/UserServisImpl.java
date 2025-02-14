package com.example.springboottema4.servis.impl;

import com.example.springboottema4.dto.UserDtoRes;
import com.example.springboottema4.dto.req.UserDtoReq;
import com.example.springboottema4.entity.Rol;
import com.example.springboottema4.entity.Usuario;
import com.example.springboottema4.exception.NotFoundException;
import com.example.springboottema4.mapper.UserMapper;
import com.example.springboottema4.repository.UserRepository;
import com.example.springboottema4.servis.UserServis;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserServisImpl implements UserServis {
    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    @Autowired
    private UserMapper modelMapper;  // Para convertir entre entidades y DTOs

    @Override
    public UserDtoRes getUser(Long id) {

        return UserMapper.toDTO(userRepository.findById(id).orElseThrow(() -> new NotFoundException("no se encontro usuario")));
    }


    @Override
    public UserDtoRes createUser(UserDtoReq userDTOReq) {
        Usuario user = UserMapper.toUserEntity(userDTOReq);

       // if (user.getProfileImage() == null || user.getProfileImage().isEmpty()) {
       //     user.setProfileImage("https://res.cloudinary.com/dmwsuzs94/image/upload/v1728906889/user_n1laeq.jpg");
       // }

        // Asegúrate de que estás codificando la contraseña
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    public UserDtoRes getUserById(Long id) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + id + "no fue encontrado"));
        return UserMapper.toDTO(user);
    }

    public UserDtoRes updateUser(Long id, UserDtoReq userDTOReq) {
        Usuario existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + id + "no fue encontrado"));

        existingUser.setUsuario(userDTOReq.usuario());
        existingUser.setPassword(userDTOReq.password());
        existingUser.setEmail(userDTOReq.email());
        existingUser.setUserEnum(Rol.valueOf(userDTOReq.userEnum()));

        existingUser = userRepository.save(existingUser);
        return UserMapper.toDTO(existingUser);
    }

    public void deleteUser(Long id) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("El usuario con ID: " + id + "no fue encontrado"));
        userRepository.delete(user);
    }

    public List<UserDtoRes> getAllUsers() {
        List<Usuario> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public UserDtoRes updateProfileImage(Long id, String imageUrl) {
        Usuario user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));
        //user.setProfileImage(imageUrl);
        userRepository.save(user);
        return UserMapper.toDTO(user);
    }

}
