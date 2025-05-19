package com.example.Contact_Manager.service;

import com.example.Contact_Manager.entities.Myuser;
import com.example.Contact_Manager.repositories.MyuserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MyuserRepositories myuserRepositories;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Myuser> optionalUser = myuserRepositories.findByEmail(username);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }
        Myuser user = optionalUser.get();
        return new CustomUserDetails(user);
    }
}
