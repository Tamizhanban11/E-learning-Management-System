package com.example.elms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CombinedController {

    @FXML
    private TextField email;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password;

    @FXML
    private Button registerButton;

    @FXML
    private BorderPane signupButton;

    @FXML
    private AnchorPane Register;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD_DB = "Mr_black_kidd_46";

    @FXML
    public void toview(ActionEvent event) throws IOException {
        loadFXML("hello-view.fxml", event);
    }

    @FXML
    public void tohome(ActionEvent event) throws IOException {
        loadFXML("Home.fxml", event);
    }

    @FXML
    public void toregister(ActionEvent event) throws IOException {
        loadFXML("Register.fxml", event);
    }

    @FXML
    public void tovedio(ActionEvent event) throws IOException {
        loadFXML("demo2.fxml", event);
    }

    @FXML
    public void registerUser() {
        String userEmail = email.getText();
        String userName = name.getText();
        String userPassword = password.getText();

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD_DB);
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

    private void loadFXML(String fxmlFileName, ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root,800,800);
        stage.setScene(scene);
        stage.show();
    }
}
