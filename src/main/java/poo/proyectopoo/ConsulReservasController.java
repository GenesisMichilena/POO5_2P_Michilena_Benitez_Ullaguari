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
        
        
    }
    
    private void llenarScrollPane() {
    File file = new File("Reserva.txt");
    try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
        String linea;
        while ((linea = bf.readLine()) != null) {
            String partes[] = linea.split(",");
            if (partes.length >= 2) {
                String codigo = partes[0].trim();
                String nombrePasajero = partes[1].trim();
                Label lb = new Label(codigo + nombrePasajero);
                vb.getChildren().add(lb);
            }
        }
    } catch (IOException e) {
        System.out.println("Ha ocurrido un error al leer el archivo.");
        e.printStackTrace();
    }
}

            }