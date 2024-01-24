/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import poo.proyectopoo.clases.Promocion;
/**
 * Clase controladora FXML para manejar las promociones.
 *
 * Esta clase controladora es responsable de inicializar y manejar eventos relacionados con las promociones.
 * Carga una imagen desde el directorio de recursos y la muestra en un ImageView.
 *
 * @author Home
 */
public class PromocionesController implements Initializable {

    @FXML
    private ImageView imgView;
    ArrayList<Promocion> promocion = Promocion.leerArchivo("promociones.txt");
    
    
    @Override
    /**
     * Inicializa la clase controladora.
     *
     * Este método se llama cuando se carga el archivo FXML. Carga una imagen desde el directorio de recursos
     * y la establece en el ImageView.
     *
     * @param url La ubicación utilizada para resolver rutas relativas para el objeto raíz, o null si la ubicación
     * no es conocida.
     * @param rb Los recursos utilizados para localizar el objeto raíz, o null si el objeto raíz no fue localizado.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
         
    }
    
    private Image crearMapa() {
        // Crear una imagen para representar el separador
        Image Mapas = new Image(getClass().getResource("/Imagenes/mapa.png").toExternalForm());
        
        return Mapas;
    }
    
    void mostrarPromociones(ActionEvent e) {
    Stage stage = new Stage();
    ArrayList<Promocion> promociones = new ArrayList<>();
    AnchorPane contenedor = new AnchorPane();
    contenedor.setMaxSize(700, 700);
    contenedor.setMinSize(700, 700);
    
    imgView.setImage(crearMapa());
    

    // Crear y mostrar la escena
    Scene scene = new Scene(contenedor, 610, 465);
    stage.setScene(scene);
    stage.setTitle("Promociones");
    stage.show();

    // Llamar a un método para mostrar marcadores de promociones en el mapa
    mostrarPromocionesEnMapa(promociones, contenedor);
}
    
    
     public static void mostrarPromocionesEnMapa(ArrayList<Promocion> pr, AnchorPane contenedor){
       Thread point = new Thread(new Runnable(){
           public void run(){
               mostrarPromocionesEnMapa(pr,contenedor);
           }
       });
       point.start();
   }
     
     

  }
    

