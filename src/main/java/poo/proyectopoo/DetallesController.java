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
     * Clase de controlador FXML para mostrar los detalles del vuelo.
     *
     * Este controlador se encarga de inicializar y mostrar los detalles del vuelo.
     * Maneja los componentes de la interfaz de usuario definidos en el archivo FXML asociado.
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
    private Button btnCerrar;
    
    /**
     * Muestra los detalles del vuelo en la interfaz.
     * 
     * @param t Objeto de la clase Tarifa que contiene la información de la tarifa.
     * @param v Objeto de la clase Vuelo que contiene la información del vuelo.
     */
    
    public void mostrarDetalles(Tarifa t,Vuelo v){
        codigoAvion.setText("Codigo de avion: "+ v.getCodigoAvion());
        codigoAvion.setFont(Font.font("System", FontWeight.BOLD, 12));
        numVuelo.setText("Numero de vuelo: "+ v.getNumeroVuelo());
        numVuelo.setFont(Font.font("System", FontWeight.BOLD, 12));
        tipoTarifa.setText("Tipo de tarifa: "+ t.getTipo());
        tipoTarifa.setFont(Font.font("System", FontWeight.BOLD, 12));
    }
    
     /**
     * Maneja el evento de cerrar la ventana.
     * 
     * @param event Evento de acción que desencadena el cierre de la ventana.
     */
    @FXML
    private void Cerrar(ActionEvent event) {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }
    
    
}
