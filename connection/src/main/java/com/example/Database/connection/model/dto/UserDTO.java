package com.example.Database.connection.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotBlank(message = "Emri nuk duhet lene bosh")
    private String name;

    @NotBlank(message = "Emaili nuk duhet lene bosh")
    @Email(message = "Emaili duhet te jete ne formatin e duhur")
    private String email;
}
