package com.service.serviceWeb.servlet;

import com.service.serviceWeb.en.Type;
import com.service.serviceWeb.manager.ClientManager;
import com.service.serviceWeb.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        ClientManager clientManager = new ClientManager();
        Client user = clientManager.getUserByEmailAndPassword(email, password);
        if(user == null){
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            if (user.getType() == Type.MANAGER){
            resp.sendRedirect("/managerHome");

            }else{
            resp.sendRedirect("/userHome");
            }
        }

    }
}
