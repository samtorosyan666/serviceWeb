package com.service.serviceWeb.servlet;

import com.service.serviceWeb.manager.VisitManager;
import com.service.serviceWeb.model.Client;
import com.service.serviceWeb.model.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/userHome")
public class UserHomeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Client client = (Client) session.getAttribute("user");
        VisitManager visitManager = new VisitManager();
        Visit allVisitsByClientId = visitManager.getVisitById(client.getId());
        req.setAttribute("visit",allVisitsByClientId);
        req.getRequestDispatcher("/WEB-INF/userHome.jsp").forward(req,resp);
    }
}
