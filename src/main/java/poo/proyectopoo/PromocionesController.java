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
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    ArrayList<Promocion> promociones;
    @FXML
    private ImageView imgView;
    @FXML
    private AnchorPane ancor;
    @FXML
    private AnchorPane ancorImg;

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
        // Inicialización de la clase, si es necesaria
        InputStream image = getClass().getResourceAsStream("/Imagenes/mapa.jpg");
        imgView.setImage(new Image(image));
        encontrar();
    }

    /**
<<<<<<< HEAD
     * Localiza las ubicaciones de las promociones y muestra la información de cada promoción.
     * Este método carga las promociones desde el archivo "promociones.txt" y muestra las imágenes
     * correspondientes en el contenedor especificado.
     .
     */
=======
     * Localiza las ubicaciones de las promociones además de mostrar información de la promoción.
     * @param e Acción capturada al presionar un botón
     */
    
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
    public void encontrar() {

        promociones=Promocion.leerArchivo("promociones.txt");
        Thread dormir = new Thread(new Runnable(){
            @Override
            public void run(){
               mostrarImagenes(promociones,ancorImg);
           }});
        dormir.start();
    }

<<<<<<< HEAD
        /**
     * Muestra imágenes de promociones en un contenedor.
     * Cada imagen tiene un temporizador para simular una presentación de diapositivas.
     * Al hacer clic en una imagen, se muestra una ventana emergente con detalles de la promoción.
     *
     * @param promociones Lista de objetos Promocion que contiene la información de las promociones.
     * @param contenedor  El AnchorPane en el que se mostrarán las imágenes.
     */
=======
    // Método principal para mostrar imágenes de promociones
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
    public void mostrarImagenes(ArrayList<Promocion> promociones, AnchorPane contenedor) {
        for (Promocion promo : promociones) {
            InputStream image2 = getClass().getResourceAsStream("/Imagenes/point.png");
            ImageView imgv = new ImageView(new Image(image2));
            Random rd = new Random();
            int numero = rd.nextInt(10) + 1;
            try {
               Thread.sleep(numero*1000);
           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }
            
            // Lógica para mostrar información detallada al hacer clic en la imagen
            imgv.setOnMouseClicked(event -> {
                Stage informacion = new Stage();
                VBox cinfo = new VBox();
                cinfo.setMaxSize(300, 250);
                cinfo.setMinSize(300, 250);
<<<<<<< HEAD
                cinfo.setStyle("-fx-background-color:#eeb5ed;");
                HBox cprom = new HBox();
                Label promos= new Label("\n\nDetalles de la Promoción\n");
                promos.setStyle("-fx-font-family:'Arial Black';");
                cprom.getChildren().addAll(promos);

                HBox cdatos = new HBox();
                Label datos = new Label("\nCódigo: " + promo.getCodigo() + "\n\nDescuento: " + promo.getDescuento() + "%\n\n\n\n\n\n");
=======
                cinfo.setStyle("-fx-background-color:#eeb4ed;");
                HBox cheladeria = new HBox();
                Label heladeria = new Label("\n\nDetalles de la Promoción\n");
                heladeria.setStyle("-fx-font-family:'Arial Black';");
                cheladeria.getChildren().addAll(heladeria);

                HBox cdatos = new HBox();
                Label datos = new Label("\nCódigo: " + promo.getCódigo() + "\n\nDescuento: " + promo.getDescuento() + "%\n\n\n\n\n\n");
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
                cdatos.getChildren().addAll(datos);

                HBox ctiempo = new HBox();
                Label tiempo = new Label();
                tiempo.setText("Cerrando en 5 segundos..                        ");
                Button cerrar = new Button("Cerrar");
                cerrar.setOnAction(event2 -> {
                    informacion.close();
                });
                ctiempo.getChildren().addAll(tiempo, cerrar);

<<<<<<< HEAD
                cinfo.getChildren().addAll(cprom, cdatos, ctiempo);
=======
                cinfo.getChildren().addAll(cheladeria, cdatos, ctiempo);
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
                Scene escena = new Scene(cinfo);
                informacion.setScene(escena);
                informacion.setTitle("Detalle de la Promoción");
                informacion.show();
                iniciarcerrar(tiempo, informacion);
            });

            Platform.runLater(() -> {
                contenedor.getChildren().add(imgv);
                imgv.setLayoutX(promo.getCoordenadaX());
                imgv.setLayoutY((promo.getCoordenadaY()-56));
                imgv.setFitHeight(40);
                imgv.setFitWidth(40);
            });
        }
    }

    /**
     * Cierra la ventana después de un tiempo además de que avisa mediante un label el tiempo que falta para que se cierre la ventana
     * @param label Etiqueta que muestra el tiempo faltante para que se cierre la ventana
     * @param escenario Ventana a cerrar
     */
    public static void cerrar(Label label, Stage escenario) {
        for (int i = 5; i != 0; i--) {
            String status = "Cerrando en " + i + " segundos..                                ";
            Platform.runLater(() -> label.setText(status));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        Platform.runLater(escenario::close);
    }
    public static void iniciarcerrar(Label label, Stage escenario) {
        Thread dormir2 = new Thread(() -> cerrar(label, escenario));
        dormir2.start();
    }

    /**
     * Inicia el metodo mostrarImagenes
     * @param locales ArrayList que contiene diferentes locales que deben ser ubicados
     * @param contenedor Contenedor que se usara para posicionar los locales
     */
    
<<<<<<< HEAD
}
=======
}
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
