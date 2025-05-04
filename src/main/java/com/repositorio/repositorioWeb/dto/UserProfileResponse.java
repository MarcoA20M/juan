package com.repositorio.repositorioWeb.dto;

import com.repositorio.repositorioWeb.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserProfileResponse {
    private String firstName;
    private String lastName;
    private String maternalLastName;
    private String email;
    private Role role;
    private String grade; // o cualquier otro campo adicional
}