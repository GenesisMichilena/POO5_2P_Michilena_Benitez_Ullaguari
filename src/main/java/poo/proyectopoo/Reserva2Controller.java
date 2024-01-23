/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author flsan
 */
public class Reserva2Controller implements Initializable {

    
    @FXML
    private ComboBox<String> cbxOrden;
    @FXML
    private ScrollPane scrpVuelos;
    @FXML
    private Label lblTitulo;
    @FXML
    private VBox vboxVuelos;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    
    @FXML
    public void buscar(String origen, String destino) {
        try (BufferedReader br = new BufferedReader(new FileReader("vuelos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                String vueloOrigen = partes[1].trim();
                String vueloDestino = partes[2].trim();

                // Verificar si el vuelo coincide con el origen y destino seleccionados
                if (vueloOrigen.equals(origen) && vueloDestino.equals(destino)) {
                    // Crear TitledPane para representar un vuelo específico
                    TitledPane vueloTitledPane = new TitledPane();
                    vueloTitledPane.setText("Vuelo: " + partes[0]);
                    vueloTitledPane.setCollapsible(false); // Desactivar colapsar/expandir

                    // Crear nodos para representar la duración y el precio
                    Label duracionLabel = new Label("Duración: " + partes[3].trim() + " horas");
                    Label precioLabel = new Label("Precio: $" + partes[7].trim());

                    // Crear HBox para representar la hora de salida, el separador y la hora de llegada
                    HBox horasBox = new HBox();
                    Label salidaLabel = new Label("Hora de salida: " + partes[4].trim());
                    ImageView separadorImage = crearSeparador();
                    Label llegadaLabel = new Label("Hora de llegada: " + partes[5].trim());
                    horasBox.getChildren().addAll(salidaLabel, separadorImage, llegadaLabel);

                    // Configurar alineación de la duración y precio
                    VBox.setVgrow(duracionLabel, Priority.ALWAYS);
                    VBox.setVgrow(precioLabel, Priority.ALWAYS);
                    duracionLabel.setAlignment(Pos.TOP_CENTER);
                    precioLabel.setAlignment(Pos.CENTER);

                    // Crear VBox para agregar los nodos
                    VBox vueloBox = new VBox(duracionLabel, horasBox, precioLabel);

                    // Configurar el contenido del TitledPane
                    vueloTitledPane.setContent(vueloBox);

                    // Agregar el TitledPane del vuelo específico al ScrollPane
                    vboxVuelos.getChildren().add(vueloTitledPane);
                    
                    // Configurar evento de clic para el VBox del vuelo
                    vueloBox.setOnMouseClicked(event -> {
                        // Cargar la nueva ventana "Tarifa"
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("Tarifa.fxml"));
                            Parent root = fxmlLoader.load();
                            Stage vt = new Stage();
                            vt.setScene(new Scene(root));
                            vt.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ImageView crearSeparador() {
        // Crear una imagen para representar el separador
        ImageView separadorImage = new ImageView(new Image(getClass().getResource("/Imagenes/separador.jpg").toExternalForm()));
        separadorImage.setFitWidth(50); // Ajusta el ancho según tus necesidades
        separadorImage.setPreserveRatio(true);
        return separadorImage;
    }


}

