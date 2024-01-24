/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Sebastian. B
 */
public class MenuController implements Initializable {

    @FXML
    private Label txtBienvenida;
    @FXML
    private Button btnPromociones;
    @FXML
    private Button btnRegistrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtBienvenida.setText("Bienvenid@ "+InicioSesionController.cliente.getNombre());
    }    
    
    @FXML
    private void PromocionesMes(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(App.class .getResource("Promociones.fxml"));
                Parent rt = fxmlLoader.load();
                Stage st= new Stage();
                st.setScene(new Scene(rt));
                st.show();
    }

    @FXML
    private void Registrar(ActionEvent event) throws IOException {
            try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Reservar.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            } catch (IOException e) {
            e.printStackTrace();
            }
        }

}