package com.hexadefence.spkeycloakclient.controller;

import org.keycloak.KeycloakPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/api")
public class SimpleController {

    @GetMapping("/public")

    public String getPublicResource(HttpServletRequest httpServletRequest){
        return "This is a public resource " + new Date().toString();
    }

    @GetMapping("/private")
    public String getPrivateResource(HttpServletRequest httpServletRequest){

        KeycloakPrincipal keycloakPrincipal = (KeycloakPrincipal) httpServletRequest.getUserPrincipal();

        return "This is a private resource " + new Date().toString();
    }
}
