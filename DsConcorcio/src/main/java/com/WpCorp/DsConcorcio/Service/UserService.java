package com.WpCorp.DsConcorcio.Service;

import com.WpCorp.DsConcorcio.DTO.RegisterUserDTO;
import jakarta.validation.Valid;

import java.net.URI;

public interface UserService {

    public URI saveUser(RegisterUserDTO userDTO);
    boolean checkExists(@Valid RegisterUserDTO userDTO);
}
