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
import javafx.stage.Window;
/**
 * FXML Controller class
 *
 * @author Sebastian. B
 */
public class InicioSesionController implements Initializable {


    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtContraseña;
    @FXML
    private Label lblMensaje;
    @FXML
    private Button btnIniciarSesion;
    static Cliente cliente;
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
                Stage s = (Stage)btnIniciarSesion.getScene().getWindow();
                cliente=cli;
                s.close();
                FXMLLoader fxmlLoader= new FXMLLoader(App.class .getResource("Menu.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                
                FXMLLoader fxmlLoader1= new FXMLLoader(App.class .getResource("ConsulReservas.fxml"));
                Parent rt = fxmlLoader1.load();
                Stage st= new Stage();
                st.setScene(new Scene(rt));
                st.show();
                break;
            }else{
                msg="Usuario o contraseña incorrecta";
            }
        }
        this.lblMensaje.setText(msg);
        
    }


}