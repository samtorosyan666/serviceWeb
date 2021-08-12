package com.service.serviceWeb.manager;

import com.service.serviceWeb.db.DBConnectionProvider;
import com.service.serviceWeb.en.Type;
import com.service.serviceWeb.model.Client;
import com.service.serviceWeb.model.Employer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();

    public void addClient(Client client) {
        try {
            String query = "INSERT INTO `client` (`name`,`surname`,`email`,`password`,`number`,`type`) " +
                    "VALUES(?,?,?,?,?,?);";
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, client.getName());
            pStatement.setString(2, client.getSurname());
            pStatement.setString(3, client.getEmail());
            pStatement.setString(4, client.getPassword());
            pStatement.setInt(5,client.getNumber());
            pStatement.setString(6,client.getType().name());
            System.out.println(query);
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                client.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }public void addEmployer(Employer employer) {
        try {
            String query = "INSERT INTO `employer` (`name`,`profession`,`contact`) " +
                    "VALUES(?,?,?);";
            PreparedStatement pStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pStatement.setString(1, employer.getName());
            pStatement.setString(2, employer.getProfession());
            pStatement.setInt(3, employer.getContact());
            System.out.println(query);
            pStatement.executeUpdate();
            ResultSet generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                employer.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Client> getClients() {
        String sql = "SELECT * from client";
        List<Client> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Client client = Client.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .number(resultSet.getInt(6))
                        .type(Type.valueOf(resultSet.getString(7)))
                        .build();
                result.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    } public List<Employer> getEmployers() {
        String sql = "SELECT * from employer";
        List<Employer> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Employer employer = Employer.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .profession(resultSet.getString(3))
                        .contact(resultSet.getInt(4))
                        .build();
                result.add(employer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public Client getClientById(int id) {
        String sql = "SELECT * FROM client WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Client.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .number(resultSet.getInt(6))
                        .type(Type.valueOf(resultSet.getString(7)))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Employer getEmployerById(int id) {
        String sql = "SELECT * FROM employer WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Employer.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .profession(resultSet.getString(3))
                        .contact(resultSet.getInt(4))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Client getUserByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM client WHERE email='" + email + "' and password = '" + password+"'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Client.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .surname(resultSet.getString(3))
                        .email(resultSet.getString(4))
                        .password(resultSet.getString(5))
                        .number(resultSet.getInt(6))
                        .type(Type.valueOf(resultSet.getString(7)))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteClient(int id) {
        String sql = "DELETE from client where id = " + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
