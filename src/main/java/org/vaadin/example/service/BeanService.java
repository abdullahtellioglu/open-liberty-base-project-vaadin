package org.vaadin.example.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.vaadin.example.view.PrototypeScopedView;
import org.vaadin.example.view.SessionScopedView;

@Configuration
public class BeanService {


    @Bean
    @Scope("session")
    public SessionScopedView sessionScopedView(){
        System.out.println("Session scope bean is created");
        return new SessionScopedView();
    }

    @Bean
    @Scope("prototype")
    public PrototypeScopedView prototypeScopedView(){
        System.out.println("Prototype scope bean is created");
        return new PrototypeScopedView();
    }
}
