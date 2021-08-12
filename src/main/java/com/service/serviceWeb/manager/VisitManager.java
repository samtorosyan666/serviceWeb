package com.service.serviceWeb.manager;

import com.service.serviceWeb.db.DBConnectionProvider;
import com.service.serviceWeb.en.Car;
import com.service.serviceWeb.model.Employer;
import com.service.serviceWeb.model.Visit;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class VisitManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();
    private ClientManager clientManager = new ClientManager();
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public void addVisit(Visit visit) {
        try {
            String query = "INSERT INTO `visit` (`employer_id`,`client_id`,`car`,`created_date`) " +
                    "VALUES(?,?,?,?);";
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setInt(1, visit.getEmployerId());
            pStatement.setInt(2, visit.getClientId());
            pStatement.setString(3, visit.getCar().name());
            pStatement.setString(4, sdf.format(visit.getCreatedDate()));
            System.out.println(query);
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                visit.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public List<Visit> getVisits(){

        String sql = "SELECT * from visit";
        List<Visit> result = new ArrayList<>();
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                Visit visit = Visit.builder()
                        .id(resultSet.getInt(1))
                        .employerId(resultSet.getInt(2))
                        .clientId(resultSet.getInt(3))
                        .car(Car.valueOf(resultSet.getString(4)))
                        .createdDate(resultSet.getDate(5))
                        .build();
                result.add(visit);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

    public Visit getVisitById(int id) {
        String sql = "SELECT * FROM visit WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Visit.builder()
                        .id(resultSet.getInt(1))
                        .employerId(resultSet.getInt(2))
                        .clientId(resultSet.getInt(3))
                        .car(Car.valueOf(resultSet.getString(4)))
                        .createdDate(resultSet.getDate(5))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteVisit(int id) {
        String sql = "DELETE from visit where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
