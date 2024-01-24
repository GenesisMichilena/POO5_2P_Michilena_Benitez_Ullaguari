/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import poo.proyectopoo.clases.Vuelo;


/**
 * FXML Controller class
 *
 * @author flsan
 */
public class Reserva2Controller implements Initializable {
    ArrayList<Vuelo> vuelosConsultar;
    
    @FXML
    private ComboBox<String> cbxOrden;
    @FXML
    private ScrollPane scrpVuelos;
    @FXML
    private Label lblTitulo;
    @FXML
    private VBox vboxVuelos;
    @FXML
    private VBox dynamicVBox;
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       cbxOrden.getItems().addAll("Precio", "Duración");
       vuelosConsultar = Vuelo.leerArchivoVuelos("vuelos.txt");
       buscar(ReservarController.origen,ReservarController.destino);
       cbxOrden.setOnAction(event -> ordenarVuelos());
 
    }    

    @FXML
    public void buscar(String origen, String destino) {
    lblTitulo.setText("Selecciona tu vuelo "+origen+" - "+destino);
    // Limpiar el VBox antes de agregar nuevos elementos
    dynamicVBox.getChildren().clear();

    for (Vuelo vuelo : vuelosConsultar) {
        if (vuelo.getOrigen().equals(origen) && vuelo.getDestino().equals(destino)) {
            // Crear VBox para representar un vuelo específico
            VBox vueloVBox = new VBox();
            VBox.setVgrow(vueloVBox, Priority.ALWAYS);

            // Crear nodos para representar la duración y el precio
            Label duracionLabel = new Label("Duración: " + vuelo.getDuracion() + " horas");
            Label precioLabel = new Label("Precio: $" + vuelo.getPrecio());

            // Crear HBox para representar la hora de salida y la hora de llegada
            HBox horasBox = new HBox();
            Label salidaLabel = new Label(vuelo.getHoraSalida());
            Label llegadaLabel = new Label(vuelo.getHoraLlegada());
            horasBox.getChildren().addAll(salidaLabel,crearSeparador(), llegadaLabel);
            horasBox.setAlignment(Pos.CENTER);

            // Establecer el texto alineado al centro y negrita
            duracionLabel.setTextAlignment(TextAlignment.CENTER);
            precioLabel.setTextAlignment(TextAlignment.CENTER);
            salidaLabel.setTextAlignment(TextAlignment.CENTER);
            llegadaLabel.setTextAlignment(TextAlignment.CENTER);

            duracionLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            precioLabel.setFont(Font.font("System", FontWeight.BOLD, 12));

            // Establecer estilos directamente en el VBox
            vueloVBox.setAlignment(Pos.CENTER);
            vueloVBox.setStyle("-fx-border-color: grey; -fx-border-width: 0.1px; -fx-padding: 10px; -fx-margin: 10px;");
            

            // Agregar nodos al VBox del vuelo
            vueloVBox.getChildren().addAll(duracionLabel, horasBox, precioLabel);

            // Establecer el ancho del VBox igual al ancho del ScrollPane
            vueloVBox.prefWidthProperty().bind(scrpVuelos.widthProperty());

            // Agregar el VBox del vuelo al VBox principal
            dynamicVBox.getChildren().add(vueloVBox);
            
            

            // Agregar evento de clic al VBox del vuelo
            vueloVBox.setOnMouseClicked(event -> abrirVentanaTarifas());
        }
    }
}


    private ImageView crearSeparador() {
        // Crear una imagen para representar el separador
        ImageView separadorImage = new ImageView(new Image(getClass().getResource("/Imagenes/separador.png").toExternalForm()));
        separadorImage.setFitWidth(100); // Ajusta el ancho según tus necesidades
        separadorImage.setPreserveRatio(true);
        return separadorImage;
    }
    
    private void abrirVentanaTarifas() {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Tarifa.fxml"));
        Parent root = fxmlLoader.load();
        Stage vt = new Stage();
        vt.setScene(new Scene(root));
        vt.show();
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    

    private void ordenarVuelos() {
    String seleccion = cbxOrden.getValue();

    if (seleccion != null) {
        // Ordenar la lista de vuelos según la selección del ComboBox
        switch (seleccion) {
            case "Precio":
                Collections.sort(vuelosConsultar, Comparator.comparingDouble(Vuelo::getPrecio));
                break;
            case "Duración":
                Collections.sort(vuelosConsultar, Comparator.comparingInt(Vuelo::getDuracion));
                break;
            // Puedes agregar más casos según tus necesidades
        }

        // Volver a mostrar los vuelos en el ScrollPane
        buscar(ReservarController.origen,ReservarController.destino);  // Puedes ajustar los parámetros según tus necesidades
    }
}
    
}