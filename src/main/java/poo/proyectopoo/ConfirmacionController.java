/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import poo.proyectopoo.clases.Pago;
import poo.proyectopoo.clases.Reserva;

/**
 * FXML Controller class
 *
 * @author flsan
 */
public class ConfirmacionController implements Initializable {
    
    @FXML
    private Label lbldinamico;
    @FXML
    private AnchorPane contendeor;
    @FXML
    private Label codigo;
    @FXML
    private Button boton;
    
    public static String codigoReserva;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        codigoReserva = generarCodigo();
        codigo.setText("Codigo reserva: " + codigoReserva);
        
        boton.setOnAction(event -> {
            Stage s = (Stage) boton.getScene().getWindow();
            s.close();
        });
        Reserva reserva = instanciarReserva();
        Reserva.escribirArchivoReserva(reserva);
        serializarReserva(reserva,codigoReserva);
        cerrar(lbldinamico);
    }    
    
    public String generarCodigo() {
        int length = 6;
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char ch = (char) (random.nextInt(26) + 'A');
            sb.append(ch);
        }

        return sb.toString();
    }
    
    public void cerrar(Label label) {
    new Thread(() -> {
        for (int i = 5; i != 0; i--) {
            String status = "Cerrando en " + i + " segundos...";
            Platform.runLater(() -> label.setText(status));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        Platform.runLater(() -> {
            Stage stage = (Stage) label.getScene().getWindow();
            stage.close();
        });
    }).start();
}
    
    public Reserva instanciarReserva(){
        Reserva r = new Reserva(codigoReserva,InicioSesionController.cliente.getCedula(),ReservarController.origen,ReservarController.destino,ReservarController.salida,ReservarController.regreso,ReservarController.pasajeros,VueloIdaController.vueloIDA.getNumeroVuelo(),VueloRegresoController.vueloRegreso.getNumeroVuelo(),TarifaController.tarifaIDA.getTipo(),TarifaRegresoController.tarifaRegreso.getTipo());
        return r;
    }
    
    public void serializarReserva(Reserva reserva, String nombreArchivo) {
        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(reserva);
            System.out.println("La reserva se ha serializado correctamente en " + nombreArchivo);
        } catch (Exception ex) {
            System.err.println("Error al serializar la reserva: " + ex.getMessage());
        }
    }
}
