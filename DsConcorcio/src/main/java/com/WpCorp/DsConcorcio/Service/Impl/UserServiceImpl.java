package com.WpCorp.DsConcorcio.Service.Impl;

import com.WpCorp.DsConcorcio.DTO.RegisterUserDTO;
import com.WpCorp.DsConcorcio.Entity.RoleEntity;
import com.WpCorp.DsConcorcio.Entity.UserEntity;
import com.WpCorp.DsConcorcio.Enum.RoleType;
import com.WpCorp.DsConcorcio.Repository.RoleRepository;
import com.WpCorp.DsConcorcio.Repository.UserRepository;
import com.WpCorp.DsConcorcio.Service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
@Log4j2
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRe;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional(readOnly = true)
    public boolean checkExists(RegisterUserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) return true;
        return false;
    }

    @Transactional
    public URI saveUser(RegisterUserDTO userDTO) {
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(userDTO, user);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        RoleEntity role1 = roleRe.findByType(RoleType.ROLE_ADMIN.name());
        user.getRoles().add(role1);
        user = userRepository.save(user);
        log.info("User Content: {}", user.toString());
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
    }


}
