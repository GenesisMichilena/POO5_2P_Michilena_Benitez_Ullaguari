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
<<<<<<< HEAD
    public void cambiarCursor() {
        btnIniciarSesion.setCursor(a.HAND);
    }

    @FXML
<<<<<<< HEAD
    public void restaurarCursor() {
        btnIniciarSesion.setCursor(a.DEFAULT);
    }
    
    @FXML
    private void IniciarSesion(ActionEvent event) {
    String msg = "Usuario o contraseña incorrecta";
    String Usua = this.txtUsuario.getText();
    String contra = this.txtContraseña.getText();
    Cliente.lecturaClientes();

    boolean usuarioValido = false;

    for (Cliente cli : Cliente.clientes) {
        if (Usua.equals(cli.getUsuario()) && contra.equals(cli.getContrasena())) {
=======
=======
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
    private void IniciarSesion(ActionEvent event) throws IOException {
        String Usua= this.txtUsuario.getText();
        String contra=this.txtContraseña.getText();      
        Cliente.lecturaClientes();
<<<<<<< HEAD
        boolean usuarioValido = false;

        for (Cliente cli : Cliente.clientes) {
            if (Usua.equals(cli.getUsuario()) && contra.equals(cli.getContrasena())) {
>>>>>>> john
            System.out.println(cli.getContrasena() + ' ' + cli.getUsuario());
            cliente = cli;
            usuarioValido = true;
            break;
<<<<<<< HEAD
        }
    }

    if (usuarioValido) {
=======
            }
        }

        if (usuarioValido) {
>>>>>>> john
    try {
        // Cerrar la ventana actual
        Stage ventanaActual = (Stage) btnIniciarSesion.getScene().getWindow();
        ventanaActual.close();

        // Cargar la escena de Menu.fxml
        FXMLLoader fxmlLoaderMenu = new FXMLLoader(App.class.getResource("Menu.fxml"));
        Parent rootMenu = fxmlLoaderMenu.load();
        Stage stageMenu = new Stage();
        stageMenu.setScene(new Scene(rootMenu));
        stageMenu.show();

        // Cargar la escena de consulReservas.fxml
        FXMLLoader fxmlLoaderConsulReservas = new FXMLLoader(App.class.getResource("consulReservas.fxml"));
        Parent rootConsulReservas = fxmlLoaderConsulReservas.load();
        Stage stageConsulReservas = new Stage();
        stageConsulReservas.setScene(new Scene(rootConsulReservas));
        stageConsulReservas.show();

<<<<<<< HEAD
        // Actualizar el mensaje
        msg = "";
    } catch (IOException e) {
        e.printStackTrace();
    }
}




        this.lblMensaje.setText(msg);
=======
    } catch (IOException e) {
        e.printStackTrace();
    }
    }else
        this.lblMensaje.setText("Usuario Incorrecto");
>>>>>>> john
    }




}
=======
        for(Cliente cli:Cliente.clientes){
            
            if(Usua.equals(cli.getUsuario())&& contra.equals(cli.getContrasena())){
                
                System.out.println(cli.getContrasena()+' '+cli.getUsuario());
                Stage s = (Stage)this.btnIniciarSesion.getScene().getWindow();
                cliente=cli;
                s.close();
                FXMLLoader fxmlLoader= new FXMLLoader(App.class .getResource("Menu.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage= new Stage();
                stage.setScene(new Scene(root));
                stage.show();
                
                FXMLLoader fxmlLoader1= new FXMLLoader(App.class .getResource("consulReservas.fxml"));
                Parent rt = fxmlLoader1.load();
                Stage st= new Stage();
                st.setScene(new Scene(rt));
                st.show();
                break;
            }else{lblMensaje.setText("Usuario o contraseña incorrecta");}
        }    
    }
}
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
