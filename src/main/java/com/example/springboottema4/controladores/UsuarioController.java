package com.example.springboottema4.controladores;

import com.example.springboottema4.dto.UserDtoRes;
import com.example.springboottema4.dto.req.UserDtoReq;
import com.example.springboottema4.servis.UserServis;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RequiredArgsConstructor
@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    @Autowired
    private UserServis userService;

    //@Autowired
    //private CloudinaryService cloudinaryService;

    // Crear un nuevo usuario
    @PostMapping
    public ResponseEntity<UserDtoRes> createUser(@Valid @RequestBody UserDtoReq userDTOReq) {
        System.out.println(userDTOReq);
        UserDtoRes createdUser = userService.createUser(userDTOReq);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDtoRes> getUserById(@PathVariable Long id) {
        UserDtoRes user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    // Actualizar un usuario por ID
    @PutMapping("/{id}")
    public ResponseEntity<UserDtoRes> updateUser(@PathVariable Long id, @Valid @RequestBody UserDtoReq userDTOReq) {
        UserDtoRes updatedUser = userService.updateUser(id, userDTOReq);
        return ResponseEntity.ok(updatedUser);
    }

    // Eliminar un usuario por ID
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Obtener todos los usuarios
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserDtoRes>> getAllUsers() {
        List<UserDtoRes> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /*@PostMapping("/{id}/upload-image")
    public ResponseEntity<UserDtoRes> uploadProfileImage(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) throws IOException {
        String imageUrl = cloudinaryService.uploadImage(file);
        UserDTORes updatedUser = userService.updateProfileImage(id, imageUrl);
        return ResponseEntity.ok(updatedUser);
    }

    @PostMapping("/upload-image-url")
    public ResponseEntity<UserDTORes> uploadProfileImageByUrl(
            @AuthenticationPrincipal UserEntity loggedInUser,
            @RequestBody String imageUrl) throws IOException {
        String uploadedUrl = cloudinaryService.uploadImageByUrl(imageUrl);
        UserDTORes updatedUser = userService.updateProfileImage(loggedInUser.getId(), uploadedUrl);
        return ResponseEntity.ok(updatedUser);
    }*/
}
