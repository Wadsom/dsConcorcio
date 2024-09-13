package com.WpCorp.DsConcorcio.DTO;

import com.WpCorp.DsConcorcio.Entity.RoleEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.WpCorp.DsConcorcio.Entity.UserEntity}
 */
@Value
public class RegisterUserDTO implements Serializable {
    @Size(message = "Deve conter até 7 digitos", min = 3, max = 7)
    @NotEmpty
    String name;
    @Email
    String email;
    String password;
}