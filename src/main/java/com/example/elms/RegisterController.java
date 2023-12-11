package com.example.elms;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterController {

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerButton;

    @FXML
    public void tovedio() {
        String userEmail = email.getText();
        String userName = name.getText();
        String userPassword = password.getText();

        try {
            Connection connection = DBConnection.getConnection();
            if (connection != null) {
                System.out.println("Connected to the database!");
                String sql = "INSERT INTO register (email, name, password) VALUES (?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, userEmail);
                statement.setString(2, userName);
                statement.setString(3, userPassword);
                statement.executeUpdate();
                System.out.println("Data inserted successfully!");
                statement.close();
                connection.close();
            } else {
                System.out.println("Failed to connect to the database!");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }

    }
}
