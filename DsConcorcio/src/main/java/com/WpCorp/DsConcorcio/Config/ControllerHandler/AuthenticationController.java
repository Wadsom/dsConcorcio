package com.WpCorp.DsConcorcio.Config.ControllerHandler;

import com.WpCorp.DsConcorcio.Config.security.JwtProvider;
import com.WpCorp.DsConcorcio.DTO.JwtDto;
import com.WpCorp.DsConcorcio.DTO.LoginDto;
import com.WpCorp.DsConcorcio.DTO.RegisterUserDTO;
import com.WpCorp.DsConcorcio.Repository.RoleRepository;
import com.WpCorp.DsConcorcio.Repository.UserRepository;
import com.WpCorp.DsConcorcio.Service.Exception.UserAlreadyExistsException;
import com.WpCorp.DsConcorcio.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleRepository roleRe;
    @Autowired
    private UserRepository userRepository;


    @PostMapping("/login")
    public ResponseEntity<JwtDto> authenticateUser(@Valid @RequestBody LoginDto loginDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwt(authentication);
        return ResponseEntity.ok(new JwtDto(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody @Valid RegisterUserDTO userDTO) {
        if (userService.checkExists(userDTO))
            throw new UserAlreadyExistsException("Esse email já está em uso, por favor tente novamente com outro email");

        URI url = userService.saveUser(userDTO);
        return ResponseEntity.created(url).body("Success");

    }


}
