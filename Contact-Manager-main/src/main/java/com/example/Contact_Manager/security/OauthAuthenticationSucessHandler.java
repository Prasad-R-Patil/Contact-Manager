package com.example.Contact_Manager.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import java.io.IOException;
import java.util.Map;

@Component
public class OauthAuthenticationSucessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(OauthAuthenticationSucessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        logger.info("OAuth2 authentication success handler");

        // Ensure the principal is of type DefaultOAuth2User
        if (authentication.getPrincipal() instanceof DefaultOAuth2User) {
            DefaultOAuth2User user = (DefaultOAuth2User) authentication.getPrincipal();
            logger.info("User name: {}", user.getName());

            // Log user attributes
            Map<String, Object> attributes = user.getAttributes();
            attributes.forEach((key, value) -> logger.info("{} => {}", key, value));

            logger.info(user.getAuthorities().toString());
        } else {
            logger.warn("Authentication principal is not of type DefaultOAuth2User");
        }

        // Redirect to home
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, "/home");
    }
}
