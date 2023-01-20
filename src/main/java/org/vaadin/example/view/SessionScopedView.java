package org.vaadin.example.view;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;

public class SessionScopedView extends Div {



    public SessionScopedView(){
        add(new Text("Session Scoped"));
    }
}
