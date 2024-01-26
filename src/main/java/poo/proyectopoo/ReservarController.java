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
 * FXML Controller class
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
    
    String orig,desti,FechaSalida,FechaRegreso;
    int CantPersonas;
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
        cbxOrigen.setOnAction(new EventHandler<ActionEvent>(){
         @Override 
         public void handle(ActionEvent t){
             
             for(String origen:COrigen){
                 if(origen.equals(cbxOrigen.getValue())){
                     orig=origen;
                 }
             }
         }   
        });
        
        String linea;
        try(BufferedReader bf= new BufferedReader(new FileReader("destinos.txt"))){
            while((linea=bf.readLine())!=null){
                String[]destino= linea.split(",");
                CDestino.add(destino[0]);
                cbzDestino.getItems().add(destino[0]);
            }
        }catch(FileNotFoundException e){
            
        }
        cbzDestino.setOnAction(new EventHandler<ActionEvent>(){
         @Override 
         public void handle(ActionEvent t){
             
             for(String destino:CDestino){
                 if(destino.equals(cbzDestino.getValue())){
                     desti=destino;
                 }
             }
         }   
        });
        
        SpinnerValueFactory<Integer> svf=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        svf.setValue(1);
        spnCantidad.setValueFactory(svf);
        
        
    }
    
}
