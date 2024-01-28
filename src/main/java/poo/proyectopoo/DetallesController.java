/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import poo.proyectopoo.clases.Tarifa;
import poo.proyectopoo.clases.Vuelo;

/**
 * FXML Controller class
 *
 * @author flsan
 */
public class DetallesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarDetalles(ResumenReController.t,ResumenReController.v);
    }    
    
    @FXML
    private Label codigoAvion;
    @FXML
    private Label numVuelo;
    @FXML
    private Label tipoTarifa;
    @FXML
    private Button btnCerrrar;
    
    public void mostrarDetalles(Tarifa t,Vuelo v){
        codigoAvion.setText("Codigo de avion: "+ v.getCodigoAvion());
        codigoAvion.setFont(Font.font("System", FontWeight.BOLD, 12));
        numVuelo.setText("Numero de vuelo: "+ v.getNumeroVuelo());
        numVuelo.setFont(Font.font("System", FontWeight.BOLD, 12));
        tipoTarifa.setText("Tipo de tarifa: "+ t.getTipo());
        tipoTarifa.setFont(Font.font("System", FontWeight.BOLD, 12));
    }
    
    @FXML
    private void Cerrar(ActionEvent event) {
        Stage stage = (Stage) btnCerrrar.getScene().getWindow();
        stage.close();
    }
    
    
}
