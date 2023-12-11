package com.example.elms;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class sceneSwitch {
    public sceneSwitch(AnchorPane currentAnchorPane, String fxml) throws IOException {

        AnchorPane nextAnchorPane= FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(fxml)));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }

}
