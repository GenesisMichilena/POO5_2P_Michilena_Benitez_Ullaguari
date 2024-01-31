/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
    /**
     * Clase controladora FXML para la pantalla de reserva de vuelos.
     *
     * Esta clase controladora maneja la lógica de la pantalla de reserva de vuelos.
     * Se encarga de inicializar y controlar los componentes definidos en el archivo FXML asociado.
     *
     * @author Sebastian. B
     */
public class ReservarController implements Initializable {

    public static ArrayList<String> COrigen = new ArrayList<>();
    public static ArrayList<String> CDestino = new ArrayList<>();
    public static String origen;
    public static String destino;
    public static LocalDate salida;
    public static LocalDate regreso;
    public static int pasajeros;
    
    @FXML
    private ComboBox<String> cbxOrigen;
    @FXML
    private ComboBox<String> cbzDestino;
    @FXML
    private DatePicker dtpSalida;
    @FXML
    private DatePicker dtpRegreso;
    @FXML
    private Spinner<Integer> spnCantidad;
    @FXML
    private Button btnBuscar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            cargarOp();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    /**
     * Maneja el evento de búsqueda de vuelos.
     *
     * @param event Evento de acción que desencadena la búsqueda de vuelos.
     * @throws IOException Si ocurre un error durante la carga de las vistas FXML.
     */
    @FXML
    private void Buscar(ActionEvent event) throws IOException {
        origen = this.cbxOrigen.getValue();
        destino = this.cbzDestino.getValue();
        salida = this.dtpSalida.getValue();
        regreso = this.dtpRegreso.getValue();
        pasajeros = this.spnCantidad.getValue();

        // Cerrar la ventana actual
        Stage ventanaActual = (Stage) this.btnBuscar.getScene().getWindow();
        ventanaActual.close();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("VueloIda.fxml"));
        Parent root = fxmlLoader.load();
        Stage v2 = new Stage();
        v2.setScene(new Scene(root));
        v2.show();
}
     /**
     * Carga las opciones iniciales en los componentes de la interfaz.
     *
     * @throws IOException Si ocurre un error durante la lectura del archivo de destinos.
     */
    
    private void cargarOp() throws IOException{
        cbxOrigen.getItems().addAll("Guayaquil","Cuenca","Quito");
        
        String guayaquil,cuenca,quito;
        guayaquil="Guayaquil";
        cuenca="Cuenca";
        quito="Quito";
        
        COrigen.add(guayaquil);
        COrigen.add(cuenca);
        COrigen.add(quito);
        
        //controlador de eventos con clases anonimas 
        
        
        String linea;
        try(BufferedReader bf= new BufferedReader(new FileReader("destinos.txt"))){
            while((linea=bf.readLine())!=null){
                String[]destino= linea.split(",");
                CDestino.add(destino[0]);
                cbzDestino.getItems().add(destino[0]);
            }
        }catch(FileNotFoundException e){
            
        }
        
        SpinnerValueFactory<Integer> svf=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        svf.setValue(1);
        spnCantidad.setValueFactory(svf);
        
        
    }
    
}
