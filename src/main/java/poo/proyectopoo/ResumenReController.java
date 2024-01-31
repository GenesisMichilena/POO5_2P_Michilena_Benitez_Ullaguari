/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import poo.proyectopoo.clases.Vuelo;

/**
 * FXML Controller class
 *
 * @author flsan
 */
public class ResumenReController implements Initializable {
    public static Tarifa t;
    public static Vuelo v; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MotrarInfoIda();
        MotrarInfoRegreso();
        mostrarTotal();
        continuar();
    }    
    
    @FXML
    private VBox vD;
    
    
    public void MotrarInfoIda(){
            VBox infoBox = new VBox();
            Label fecha = new Label(ReservarController.regreso.toString());
            fecha.setFont(Font.font("System", FontWeight.BOLD, 12));
            Label lugar = new Label(ReservarController.destino + " a " +ReservarController.origen);
            lugar.setFont(Font.font("System", FontWeight.BOLD, 12));
            infoBox.getChildren().addAll(fecha,lugar);
            vD.getChildren().add(infoBox);
            
            VBox vueloVBox = new VBox();
            VBox.setVgrow(vueloVBox, Priority.ALWAYS);
            
            Label duracionLabel = new Label("Duración: " + VueloIdaController.vueloIDA.getDuracion() + " horas");
            Label precioLabel = new Label("Precio: $" + VueloIdaController.vueloIDA.getPrecio());

            HBox horasBox = new HBox();
            Label salidaLabel = new Label(VueloIdaController.vueloIDA.getHoraSalida());
            Label llegadaLabel = new Label(VueloIdaController.vueloIDA.getHoraLlegada());
            horasBox.getChildren().addAll(salidaLabel,crearSeparador(), llegadaLabel);
            horasBox.setAlignment(Pos.CENTER);
            duracionLabel.setTextAlignment(TextAlignment.CENTER);
            precioLabel.setTextAlignment(TextAlignment.CENTER);
            salidaLabel.setTextAlignment(TextAlignment.CENTER);
            llegadaLabel.setTextAlignment(TextAlignment.CENTER);
            duracionLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            precioLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            vueloVBox.setAlignment(Pos.CENTER);
            vueloVBox.setStyle("-fx-border-color: grey; -fx-border-width: 0.1px; -fx-padding: 10px; -fx-margin: 10px;");
            
                        
            VBox botonbox = new VBox();
            botonbox.setAlignment(Pos.CENTER_RIGHT);
            Button b = new Button("Detalles");
            b.setStyle("-fx-background-color: red; -fx-background-radius: 5;-fx-border-color: white;-fx-border-radius: 5;-fx-border-width: 2;");
            b.setTextFill(Color.WHITE);
            b.setOnAction(event -> {
                abrirVentanaDetalles(TarifaController.tarifaIDA, VueloIdaController.vueloIDA);
            });
            botonbox.getChildren().addAll(b);
            
            
            vueloVBox.getChildren().addAll(duracionLabel,horasBox, precioLabel, botonbox);
            vD.getChildren().add(vueloVBox);
    }

    public void MotrarInfoRegreso(){
            VBox infoBox = new VBox();
            Label fecha = new Label(ReservarController.regreso.toString());
            fecha.setFont(Font.font("System", FontWeight.BOLD, 12));
            Label lugar = new Label(ReservarController.destino + " a " +ReservarController.origen);
            lugar.setFont(Font.font("System", FontWeight.BOLD, 12));
            infoBox.getChildren().addAll(fecha,lugar);
            vD.getChildren().add(infoBox);
            
            
            VBox vueloVBox = new VBox();
            VBox.setVgrow(vueloVBox, Priority.ALWAYS);
            
            Label duracionLabel = new Label("Duración: " + VueloRegresoController.vueloRegreso.getDuracion() + " horas");
            Label precioLabel = new Label("Precio: $" + VueloRegresoController.vueloRegreso.getPrecio());

            HBox horasBox = new HBox();
            Label salidaLabel = new Label(VueloIdaController.vueloIDA.getHoraSalida());
            Label llegadaLabel = new Label(VueloIdaController.vueloIDA.getHoraLlegada());
            horasBox.getChildren().addAll(salidaLabel,crearSeparador(), llegadaLabel);
            horasBox.setAlignment(Pos.CENTER);
            duracionLabel.setTextAlignment(TextAlignment.CENTER);
            precioLabel.setTextAlignment(TextAlignment.CENTER);
            salidaLabel.setTextAlignment(TextAlignment.CENTER);
            llegadaLabel.setTextAlignment(TextAlignment.CENTER);
            duracionLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            precioLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
            vueloVBox.setAlignment(Pos.CENTER);
            vueloVBox.setStyle("-fx-border-color: grey; -fx-border-width: 0.1px; -fx-padding: 10px; -fx-margin: 10px;");
            
            VBox botonbox = new VBox();
            botonbox.setAlignment(Pos.CENTER_RIGHT);
            Button b = new Button("Detalles");
            b.setStyle("-fx-background-color: red; -fx-background-radius: 5;-fx-border-color: white;-fx-border-radius: 5;-fx-border-width: 2;");
            b.setTextFill(Color.WHITE);
            b.setOnAction(event -> {
                abrirVentanaDetalles(TarifaRegresoController.tarifaRegreso, VueloRegresoController.vueloRegreso);
            });
            botonbox.getChildren().addAll(b);
            
            vueloVBox.getChildren().addAll(duracionLabel, horasBox, precioLabel, botonbox);
            vD.getChildren().add(vueloVBox);
    }

    public void mostrarTotal(){
        VBox precioBox = new VBox();
        Label totalLabel = new Label("Precio total: "+ (TarifaController.precioVTIDA+ TarifaRegresoController.precioVTREGRESO));
        totalLabel.setFont(Font.font("System", FontWeight.BOLD, 12));
        precioBox.getChildren().addAll(totalLabel);
        precioBox.setAlignment(Pos.CENTER_RIGHT);
        vD.getChildren().add(precioBox);
    }
    
    
    
    private ImageView crearSeparador() {
        // Crear una imagen para representar el separador
        ImageView separadorImage = new ImageView(new Image(getClass().getResource("/Imagenes/separador.png").toExternalForm()));
        separadorImage.setFitWidth(100);
        separadorImage.setPreserveRatio(true);
        return separadorImage;
    }
    
    private void abrirVentanaDetalles(Tarifa ta, Vuelo vu) {
        t=ta;
        v=vu;
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Detalles.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage detallesStage = new Stage();
        detallesStage.setScene(scene);
        detallesStage.show();
        
        } catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    private void continuar(){
        VBox continuarBOX = new VBox();
        Button continuarBoton = new Button("Continuar");
        continuarBoton.setStyle("-fx-background-color: red; -fx-background-radius: 5;-fx-border-color: white;-fx-border-radius: 5;-fx-border-width: 2;");
        continuarBoton.setTextFill(Color.WHITE);
        continuarBOX.getChildren().addAll(continuarBoton);
        continuarBOX.setAlignment(Pos.CENTER);
        vD.getChildren().add(continuarBOX);
        
        continuarBoton.setOnAction(event -> {
                abrirVentanaDatos();
            });
        
     }
    
    
    private void abrirVentanaDatos() {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Datos.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage detallesStage = new Stage();
        detallesStage.setScene(scene);
        detallesStage.show();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
