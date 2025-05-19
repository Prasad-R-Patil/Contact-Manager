package com.example.Contact_Manager.security;

import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.example.Contact_Manager.service.UserServices;

@Service
public class CustomAuth2UserService extends DefaultOAuth2UserService {

    @Autowired
    @Lazy
    private UserServices userServices;
    public CustomAuth2UserService(@Lazy UserServices userServices) {
        this.userServices = userServices;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String email = oAuth2User.getAttribute("email");
        if (email == null) {
            throw new OAuth2AuthenticationException("Email attribute not found");
        }
        String name = oAuth2User.getAttribute("name");


        // Create a new OAuth2User with authorities based on roles if needed
        return new CustomAuth2User(oAuth2User.getAuthorities(),oAuth2User.getAttributes(),"name");
    }
}
