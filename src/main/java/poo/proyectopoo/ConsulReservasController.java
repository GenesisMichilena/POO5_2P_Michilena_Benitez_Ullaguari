package poo.proyectopoo;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class ConsulReservasController implements Initializable {


    @FXML
    private VBox vb;  
    @FXML
    private ScrollPane scr;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        scr.setFitToWidth(true);
        scr.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        llenarScrollPane();
        scr.setContent(vb);
<<<<<<< HEAD
<<<<<<< HEAD
        
=======
>>>>>>> john
=======
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
    }
    
    @FXML
    private void llenarScrollPane() {
    // Nombre del archivo
    String nombreArchivo = "Reserva.txt";
    
    try {
        // Intenta abrir y leer el archivo "Reserva.txt"
        File file = new File(nombreArchivo);

        if (!file.exists()) {
            // Si el archivo no existe, créalo
            file.createNewFile();
        }

        // Verifica si el archivo está vacío
        if (file.length() == 0) {
            // Muestra el mensaje en el VBox
            Label mensajeLabel = new Label("No hay viajes registrados por el momento.");
            vb.getChildren().add(mensajeLabel);
        } else {
            // Si el archivo no está vacío, procede a leer y mostrar los datos
            try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
                String linea;

<<<<<<< HEAD
                // Limpia el contenido existente en el VBox antes de llenarlo
                vb.getChildren().clear();

=======
>>>>>>> john
                // Lee cada línea del archivo y procesa la información
                while ((linea = bf.readLine()) != null) {
                    String[] partes = linea.split(",");

                    // Verifica que haya al menos dos partes en la línea
                    if (partes.length >= 2) {
                        // Obtiene el código y el nombre del pasajero
                        String codigo = partes[0].trim();
                        String nombrePasajero = partes[1].trim();

                        // Crea una etiqueta con el código y el nombre del pasajero
                        Label lb = new Label(codigo + " - " + nombrePasajero);

                        // Añade la etiqueta al VBox
                        vb.getChildren().add(lb);
                    } else {
                        System.out.println("Error: La línea no tiene el formato esperado en el archivo.");
                    }
                }
            }
        }
    } catch (IOException e) {
<<<<<<< HEAD
        // Maneja las excepciones relacionadas con la lectura o creación del archivo
=======
>>>>>>> john
        System.out.println("Ha ocurrido un error al manipular el archivo.");
        e.printStackTrace();
    }
}


<<<<<<< HEAD
<<<<<<< HEAD
            }
=======
 }
>>>>>>> john
=======
 }
>>>>>>> 9991fd81f218ce9ef3c3d031974c278456065bf1
