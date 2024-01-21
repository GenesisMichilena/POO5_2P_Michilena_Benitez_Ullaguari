/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.io.BufferedReader;
import java.io.FileInputStream;
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
<<<<<<< HEAD
import javafx.scene.Parent;
import javafx.scene.Scene;
=======
import javafx.scene.Cursor;
>>>>>>> 934ac9f6647feb9c6640657bb54fea3ad993a633

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import poo.proyectopoo.clases.Reserva;
/**
 * FXML Controller class
 *
 * @author Sebastian. B
 */
public class ReservarController implements Initializable {

    public static ArrayList<String> COrigen = new ArrayList<>();
    public static ArrayList<String> CDestino = new ArrayList<>();
    
    String orig,desti,FechaSalida,FechaRegreso;
    int CantPersonas;
    static Reserva rs;
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
    @FXML
    private Cursor a;
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
<<<<<<< HEAD
    private void Buscar(ActionEvent event) throws IOException {
        //rs= new Reserva(orig,desti,FechaSalida,FechaRegreso,CantPersonas);
        //Reserva.Reservas.add(rs);
        FXMLLoader fxmlLoader= new FXMLLoader(App.class .getResource("Reserva2.fxml"));
        Parent rt = fxmlLoader.load();
        Stage st= new Stage();
        st.setScene(new Scene(rt));
        st.show();
        Stage s = (Stage)btnBuscar.getScene().getWindow();
        s.close();
=======
    public void cambiarCursor() {
        btnBuscar.setCursor(a.HAND);
    }

    @FXML
    public void restaurarCursor() {
        btnBuscar.setCursor(a.DEFAULT);
    }
    
    @FXML
    private void Buscar(ActionEvent event) {
>>>>>>> 934ac9f6647feb9c6640657bb54fea3ad993a633
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

        LocalDate FSalida=dtpSalida.getValue();
        LocalDate FRegreso=dtpRegreso.getValue();
        FechaSalida=""+FSalida;
        FechaRegreso=""+FRegreso;
        
<<<<<<< HEAD
        SpinnerValueFactory<Integer> svf=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100);
        svf.setValue(1);
        spnCantidad.setValueFactory(svf);
        CantPersonas=spnCantidad.getValue();
=======
<<<<<<< HEAD
        SpinnerValueFactory<Integer> svf = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
        spnCantidad.setValueFactory(svf);

        // Obtener el valor seleccionado del Spinner
        CantPersonas = spnCantidad.getValue();
=======
        //SpinnerValueFactory<Integer> svf=new SpinnerValueFactory.IntegerSpinnerValueFactory(1,100,1);
        //spnCantidad.setValueFactory(svf);
        //String cp=""+spnCantidad;
        //CantPersonas=Integer.parseInt(cp);
>>>>>>> 063e5b10f513f40f0a2c78300f8ffba898ab3bf7
        
        
>>>>>>> 934ac9f6647feb9c6640657bb54fea3ad993a633
    }
}
