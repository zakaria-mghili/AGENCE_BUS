package com.example.agence;

import java.io.IOException;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ListeController implements Initializable {

    @FXML
    private Label notfound;
    @FXML
    private Button cancelsearch;
    @FXML
    private GridPane grid; // Lié au fichier FXML

    private List<String[]> data = new ArrayList<>(); // Données reçues

    // Méthode pour passer les données au contrôleur
    public void setData(List<String[]> data) {
        this.data = data;
        populateGrid(); // Remplit le GridPane après réception des données
    }

    // Remplir le GridPane
    // Remplir le GridPane
    private void populateGrid() {
        int row = 0;

        if (data.size() > 0) {
            for (int i = 0; i < data.size(); i++) {
                try {
                    System.out.println("Loading FXML for item " + i);
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("voyage.fxml"));
                    AnchorPane anchorPane = fxmlLoader.load();

                    // Configure le contrôleur de l'élément
                    VoyageController voyageController = fxmlLoader.getController();
                    voyageController.setData(data.get(i));

                    // Ajoute l'élément au GridPane
                    // grid.getChildren().add(anchorPane);
                    grid.add(anchorPane, 0, row++);
                    GridPane.setMargin(anchorPane, new Insets(10));
                } catch (IOException e) {
                    System.err.println("Error loading FXML for item " + i);
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    System.err.println("NullPointerException for item " + i);
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No data found");
            notfound.setText("No data found");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancelsearch.setOnAction(event -> {
            System.out.println("Cancel search");
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        // Cette méthode est appelée automatiquement après le chargement du FXML
        // Elle peut être utilisée pour configurer des éléments de l'interface
    }
}
