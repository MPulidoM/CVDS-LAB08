package edu.eci.cvds.servlet.model;

import org.springframework.stereotype.Component;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@Component
@ManagedBean(name = "userBean")
public class UserBean implements Serializable {
    private String name;
    private String message;

    public UserBean() {
        this.name = " ";
        this.message = "Hola";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
