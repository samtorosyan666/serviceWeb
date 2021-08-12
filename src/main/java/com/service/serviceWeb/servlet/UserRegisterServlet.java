package com.service.serviceWeb.servlet;

import com.service.serviceWeb.en.Type;
import com.service.serviceWeb.manager.ClientManager;
import com.service.serviceWeb.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/userRegister")
public class UserRegisterServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String number = req.getParameter("number");
        String type = req.getParameter("type");
        ClientManager clientManager = new ClientManager();
        clientManager.addClient(Client.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .number(Integer.parseInt(number))
                .type(Type.valueOf(type))
                .build());
        resp.sendRedirect("/managerHome");
    }
}
