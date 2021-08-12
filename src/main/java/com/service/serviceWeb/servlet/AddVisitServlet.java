package com.service.serviceWeb.servlet;

import com.service.serviceWeb.en.Car;
import com.service.serviceWeb.manager.VisitManager;
import com.service.serviceWeb.model.Client;
import com.service.serviceWeb.model.Visit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/addVisit")
public class AddVisitServlet extends HttpServlet {
private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int employerId = Integer.parseInt(req.getParameter("employer_id"));
        int clientId = Integer.parseInt(req.getParameter("client_id"));
        String car = req.getParameter("car");
        String createdDate = req.getParameter("created_date");
        VisitManager visitManager = new VisitManager();
        try {
            visitManager.addVisit(Visit.builder()
                    .employerId(employerId)
                    .clientId(clientId)
                    .car(Car.valueOf(car))
                    .createdDate(sdf.parse(createdDate))
                    .build());
        } catch (ParseException e) {
                e.printStackTrace();
        }
        resp.sendRedirect("/managerHome");
//        req.getRequestDispatcher("/WEB-INF/managerHome.jsp").forward(req,resp);
    }
}
