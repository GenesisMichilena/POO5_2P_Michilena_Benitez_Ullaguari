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
import javafx.scene.Cursor;
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
    @FXML
    private Cursor a;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtBienvenida.setText("Bienvenid@ "+InicioSesionController.cliente.getNombre());
    }
    @FXML
    public void cambiarCursor() {
        btnPromociones.setCursor(a.HAND);
        btnRegistrar.setCursor(a.HAND);
    }

    @FXML
    public void restaurarCursor() {
        btnPromociones.setCursor(a.DEFAULT);
        btnRegistrar.setCursor(a.DEFAULT);
    }
    
    @FXML
    private void PromocionesMes(ActionEvent event) throws IOException {
<<<<<<< HEAD
        FXMLLoader fxmlLoader= new FXMLLoader(App.class .getResource("Promociones.fxml"));
        Parent rt = fxmlLoader.load();
        Stage st= new Stage();
        st.setScene(new Scene(rt));
        st.show();
    }

    @FXML
<<<<<<< HEAD
    private void Registrar(ActionEvent event) {
        
        try {
=======
       try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Promociones.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            } catch (IOException e1) {
            e1.printStackTrace();
            }
    }

    @FXML
    private void Registrar(ActionEvent event) throws IOException {
            try {
>>>>>>> john
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Reservar.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
<<<<<<< HEAD
        } catch (IOException e) {
            
        }
        
    }
=======
            } catch (IOException e) {
            e.printStackTrace();
            }
        }
>>>>>>> john


}
=======
    private void Registrar(ActionEvent event) throws IOException {
        FXMLLoader fxmlL= new FXMLLoader(App.class .getResource("Reservar.fxml"));
        Parent rt1 = fxmlL.load();
        Stage st1= new Stage();
        st1.setScene(new Scene(rt1));
        st1.show();
        Stage s = (Stage)this.btnRegistrar.getScene().getWindow();                
        s.close();
    }
        
}
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
