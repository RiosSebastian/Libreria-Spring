package com.example.springboottema4.dto.req;

import lombok.NonNull;

public record UserDtoReq(@NonNull
                         // @Size(min = 3, max = 20)
                         String usuario,
                         String password,
                         @NonNull
                         // @Email
                         String email,
                         String userEnum) {
}
