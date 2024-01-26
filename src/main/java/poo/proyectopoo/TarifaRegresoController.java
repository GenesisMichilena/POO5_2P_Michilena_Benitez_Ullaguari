/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import poo.proyectopoo.clases.Tarifa;

/**
 * FXML Controller class
 *
 * @author flsan
 */
public class TarifaRegresoController implements Initializable {

ArrayList<Tarifa> tarifas;
    public static Tarifa tarifaRegreso;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tarifas = Tarifa.leerArchivo("tarifas.txt");
        mostrarTarifas();
    }
    
    @FXML
    private VBox VBoxD;
    @FXML
    private ScrollPane scrpTarifa;
   

    @FXML
    public void mostrarTarifas() {
        // Colores predefinidos
        String[] colores = {"#FFFF00", "#FFA500", "#FF69B4"}; // Amarillo, naranja, rosa

        // Crear nodos para representar las tarifas
        for (int i = 0; i < tarifas.size(); i++) {
            Tarifa t = tarifas.get(i);

            // Crear VBox para representar una tarifa específica
            VBox tarifaVBox = new VBox();
            tarifaVBox.setAlignment(Pos.CENTER); // Centrar contenido
            VBox.setVgrow(tarifaVBox, Priority.ALWAYS);

            // Crear nodos para representar la información de la tarifa
            Label tipoNombreLabel = new Label(t.getTipo() + " " + t.getNombre());
            tarifaVBox.getChildren().addAll(tipoNombreLabel);

            ArrayList<String> caracteristicas = new ArrayList<>(Arrays.asList(t.getCaracterísticas()));

            // Crear nodos para representar las características de la tarifa
            for (int x = 0; x < caracteristicas.size(); x++) {
                HBox caracteristicaBox = new HBox();
                caracteristicaBox.setAlignment(Pos.CENTER_LEFT);

                // Cargar imagen
                String imagePath = "/Imagenes/c" + (x + 1) + ".png";
                InputStream imageStream = getClass().getResourceAsStream(imagePath);
                if (imageStream != null) {
                    ImageView imageView = new ImageView(new Image(imageStream));
                    imageView.setFitHeight(35);
                    imageView.setPreserveRatio(true);
                    caracteristicaBox.getChildren().add(imageView);
                } else {
                    System.out.println("No se pudo cargar la imagen: " + imagePath);
                }

                // Crear un label para la característica
                Label caracteristicaLabel = new Label(caracteristicas.get(x));

                // Agregar el label al HBox
                caracteristicaBox.getChildren().add(caracteristicaLabel);

                // Establecer espaciado entre la imagen y el texto
                caracteristicaBox.setSpacing(5);

                // Agregar el HBox de la característica al VBox de la tarifa
                tarifaVBox.getChildren().add(caracteristicaBox);
            }

            // Calcular el costo total de la tarifa
            double costoTotal = (t.getPorcentaje() * VueloIdaController.vueloIDA.getPrecio()) + VueloIdaController.vueloIDA.getPrecio();
            Label costoTotalLabel = new Label("Costo Total: $" + costoTotal);
            costoTotalLabel.setTextFill(Color.WHITE);

            // Crear un VBox para el costo total
            VBox preciobox = new VBox();
            preciobox.setAlignment(Pos.CENTER); // Centrar contenido
            preciobox.getChildren().add(costoTotalLabel);

            String color = colores[i % colores.length];
            tarifaVBox.setStyle("-fx-border-color: " + color);
            preciobox.setStyle("-fx-background-color: " + color);

            //alineación y estilos
            tipoNombreLabel.setTextAlignment(TextAlignment.LEFT);
            tipoNombreLabel.setTextFill(Color.valueOf(color)); 
            costoTotalLabel.setTextAlignment(TextAlignment.CENTER);
            tipoNombreLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            costoTotalLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            

            // Agregar nodos al VBox de la tarifa
            tarifaVBox.getChildren().addAll(preciobox);

            // Agregar el VBox de la tarifa al VBox principal
            VBoxD.getChildren().add(tarifaVBox);
            
            //evento
            tarifaVBox.setOnMouseClicked(event -> abrirVueloRegreso(t));
        }
    }

        private void abrirVueloRegreso(Tarifa tarifa) {
        tarifaRegreso = tarifa;
        System.out.println(tarifaRegreso.toString());
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ResumenRe.fxml"));
            Parent root = fxmlLoader.load();
            Stage vt = new Stage();
            vt.setScene(new Scene(root));
            vt.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
