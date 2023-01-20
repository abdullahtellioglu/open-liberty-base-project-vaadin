package org.vaadin.example.view;

import com.vaadin.flow.component.Component;
import jakarta.inject.Inject;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class ViewFactory implements ApplicationContextAware {

    public ViewFactory(){
        System.out.println("View factory is initializing");
    }
    private ApplicationContext applicationContext;

    @Override
    @Inject
    public void setApplicationContext(final ApplicationContext paramApplicationContext) throws BeansException {
        applicationContext = paramApplicationContext;
    }


    public Component getView(String scope){
        if(scope.equals("prototype")){
            return applicationContext.getBean("prototypeScopedView", Component.class);
        }else if(scope.equals("session")){
            return applicationContext.getBean("sessionScopedView", Component.class);
        }
        return null;
    }
}
