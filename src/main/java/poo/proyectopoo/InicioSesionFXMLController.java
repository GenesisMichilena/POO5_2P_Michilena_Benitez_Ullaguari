/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;
import java.io.IOException;
import poo.proyectopoo.clases.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Sebastian. B
 */
public class InicioSesionFXMLController implements Initializable {


    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContraseña;
    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnIniciarSesion;
    @FXML
    private Label lblRegistrar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML
    private void IniciarSesion(ActionEvent event) throws IOException {
        String msg="";
        String Usua= this.txtUsuario.getText();
        String contra=this.txtContraseña.getText();      
        Cliente.lecturaClientes();
        for(Cliente cli:Cliente.clientes){
            
            if(Usua.equals(cli.getUsuario())&& contra.equals(cli.getContrasena())){
                
                System.out.println(cli.getContrasena()+' '+cli.getUsuario());
                msg="Bienvenido";
                break;
            }else{
                msg="Usuario o contraseña incorrecta";
            }
        }
        this.lblMensaje.setText(msg);
        FXMLLoader fxmlLoader= new FXMLLoader(App.class .getResource("InicioFXML.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,640,400);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Registrar(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader= new FXMLLoader(App.class .getResource("secondary.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root,640,400);
        Stage stage= new Stage();
        stage.setScene(scene);
        stage.show();
    }

}