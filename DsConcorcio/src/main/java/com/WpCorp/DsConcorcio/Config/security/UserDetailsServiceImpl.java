package com.WpCorp.DsConcorcio.Config.security;

import com.WpCorp.DsConcorcio.Entity.UserEntity;
import com.WpCorp.DsConcorcio.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userModel = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
        return UserDetailsImpl.build(userModel);
    }
//
//    public UserDetails loadUserById(UUID userId) throws AuthenticationCredentialsNotFoundException {
//        UserEntity userModel = userRepository.findById(userId)
//                .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("User Not Found with userId: " + userId));
//        return UserDetailsImpl.build(userModel);
//    }

}
