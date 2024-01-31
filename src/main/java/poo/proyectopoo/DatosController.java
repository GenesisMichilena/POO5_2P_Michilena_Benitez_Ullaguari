/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author flsan
 */
public class DatosController implements Initializable {
    
    @FXML
    private VBox vBD;
    @FXML
    private Button b;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarDatosPersona();
    }    
    
    public void mostrarDatosPersona(){
        for(int x = 0; x< ReservarController.pasajeros;x++){
            VBox boxPasajero = new VBox();
            boxPasajero.setAlignment(Pos.CENTER);
            
            //labelpasajero
            VBox pasajero = new VBox();
            Label lblPasajero = new Label("Pasajero " + (x+1));
            pasajero.getChildren().add(lblPasajero);
            
            
            //NOMBRE/APELLIDO/PASAPORTE/CORREO
           
            GridPane gridPane = new GridPane();
            gridPane.setHgap(10); 
            gridPane.setVgap(10);
            Label lblNombre = new Label("Nombre");
            TextField txtFNombre = new TextField();

            Label lblApellido= new Label("Apellido");
            TextField txtFApellido = new TextField();

            Label lblPasaporte = new Label("Pasaporte:");
            TextField txtFPasaporte = new TextField();

            Label lblCorreo = new Label("Correo:");
            TextField txtFCorreo = new TextField();

            // Añadir los elementos al GridPane
            gridPane.add(lblNombre, 1, 0); // columna 1, fila 0
            gridPane.add(txtFNombre, 2, 0); // columna 2, fila 0
            gridPane.add(lblApellido, 4, 0); // columna 4, fila 0
            gridPane.add(txtFApellido, 5, 0); // columna 5, fila 0

            gridPane.add(lblPasaporte, 1, 1); // columna 1, fila 1
            gridPane.add(txtFPasaporte, 2, 1); // columna 2, fila 1
            gridPane.add(lblCorreo, 4, 1); // columna 4, fila 1
            gridPane.add(txtFCorreo, 5, 1); // columna 5, fila 1
           
            
            boxPasajero.getChildren().addAll(gridPane);
            boxPasajero.setStyle("-fx-border-color: red" );
            boxPasajero.setPrefWidth(100);
            boxPasajero.setPrefHeight(100);
            
            vBD.getChildren().addAll(pasajero,boxPasajero);
            
            b.setOnAction(event -> {
                cambiarVentana();
            });
        }
    }
    
    public void cambiarVentana(){
        try {
        Stage stage = (Stage) vBD.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Pago.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage detallesStage = new Stage();
        detallesStage.setScene(scene);
        detallesStage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
