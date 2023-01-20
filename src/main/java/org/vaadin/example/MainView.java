package org.vaadin.example;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.vaadin.example.view.PrototypeScopedView;
import org.vaadin.example.view.SessionScopedView;
import org.vaadin.example.view.ViewFactory;

import java.time.LocalDateTime;

@Route("")
public class MainView extends VerticalLayout {

    public static final String PAGE_TAG = "";


    private Div content;


    public ViewFactory viewFactory;

    public MainView() {
        WebApplicationContext currentWebApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        System.out.println("Current web application exists = "+ currentWebApplicationContext != null);
        viewFactory = currentWebApplicationContext.getBean(ViewFactory.class);
        content = new Div();


        Button btnSession = new Button("Add Session Bean");

        Button btnPrototype = new Button("Add Prototype Bean");

        btnSession.addClickListener(event -> {
            Component component = viewFactory.getView("session");
            content.add(component);
        });

        btnPrototype.addClickListener(event -> {
            Component prototype = viewFactory.getView("prototype");
            content.add(prototype);
        });



        content.add(btnSession, btnPrototype);
        add(content);
    }

    private class UpdateThread implements Runnable {
        private Div div;
        private UI ui;

        public UpdateThread(UI ui, Div div) {
            this.div = div;
            this.ui = ui;
        }

        @Override
        public void run() {
            while (true) {
                ui.access(() -> {
                    div.removeAll();
                    div.add(new Span(LocalDateTime.now().toString()));
                });
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
