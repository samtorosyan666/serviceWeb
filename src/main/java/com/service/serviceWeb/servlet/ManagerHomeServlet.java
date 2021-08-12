package com.service.serviceWeb.servlet;

import com.service.serviceWeb.manager.ClientManager;
import com.service.serviceWeb.manager.VisitManager;
import com.service.serviceWeb.model.Client;
import com.service.serviceWeb.model.Employer;
import com.service.serviceWeb.model.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/managerHome")
public class ManagerHomeServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Client client = (Client) session.getAttribute("user");
        VisitManager visitManager = new VisitManager();
        ClientManager clientManager = new ClientManager();
        List<Employer> allEmployers = clientManager.getEmployers();
        List<Visit> allVisits = visitManager.getVisits();
        List<Client> allClients = clientManager.getClients();
        req.setAttribute("allEmployers",allEmployers);
        req.setAttribute("allVisits",allVisits);
        req.setAttribute("allClients",allClients);
        req.getRequestDispatcher("/WEB-INF/managerHome.jsp").forward(req,resp);
    }
}
