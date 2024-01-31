/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poo.proyectopoo;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Stage;
import poo.proyectopoo.Excepciones.CodigoInvalidoException;
import poo.proyectopoo.Excepciones.DatosIncompletosException;
import poo.proyectopoo.clases.Promocion;

/**
 * FXML Controller class
 *
 * @author flsan
 */
public class PagoController implements Initializable {
    ArrayList<Promocion> promociones = Promocion.leerArchivo("promociones.txt");
    public static double descuento;
    public static double valorantes;
    public static double valordespues;
    public static String tipo;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarInfo();
        try {
            if (verificarProm()) {
            detallesbox();
            }
        } catch (CodigoInvalidoException e) {
         mostrarErrorPopup2(e.getMessage());
        }
        
        b.setOnAction(event ->{
          confirmar();  
        });
        c.setOnAction(event ->{
          cancelar();  
        });
    }    
    
    @FXML
    private VBox boxDinamico;
    
    @FXML
    private VBox boxDetalles;
    
    @FXML
    private HBox boxProm;
    
    @FXML
    private TextField txtProm;
    
    @FXML
    private RadioButton E;
    
    @FXML
    private RadioButton T;
    
    @FXML
    private Button b;
    @FXML
    private Button c;
    
    
    
    
    public void mostrarInfo() {
        boxDinamico.getChildren().clear();
        ToggleGroup toggleGroup = new ToggleGroup();
        E.setToggleGroup(toggleGroup);
        T.setToggleGroup(toggleGroup);
        boxDinamico.setVisible(false);
        
        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == E) {
                mostrarCamposEfectivo();
            } else if (newValue == T) {
                mostrarCamposTarjeta();
            } else {
                boxDinamico.setVisible(false);
            }
        });
        tipo = "";
        RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
        if (selectedRadioButton != null) {
        tipo = selectedRadioButton.getText();
        }
    }
    
    private void mostrarCamposEfectivo() {
        boxDinamico.getChildren().clear();
        Label mensaje = new Label("Tiene plazo de 24h para acercarse a cancelar el valor");
        VBox box = new VBox();
        box.getChildren().add(mensaje);
        boxDinamico.getChildren().add(box);
        boxDinamico.setVisible(true);
    }
        
    private void mostrarCamposTarjeta(){
        boxDinamico.getChildren().clear();
        HBox hbox1 = new HBox();
        Label Numero = new Label("Ingrese su nombre:");
        TextField textField1 = new TextField();
        hbox1.getChildren().addAll(Numero, textField1);
        hbox1.setPadding(new Insets(5));

        HBox hbox2 = new HBox();
        Label label2 = new Label("Seleccione la fecha:");
        DatePicker datePicker = new DatePicker();
        hbox2.getChildren().addAll(label2, datePicker);
        hbox2.setPadding(new Insets(5));

        HBox hbox3 = new HBox();
        Label label3 = new Label("Ingrese su contraseña:");
        PasswordField passwordField = new PasswordField();
        hbox3.getChildren().addAll(label3, passwordField);
        hbox3.setPadding(new Insets(5));
        boxDinamico.getChildren().addAll(hbox1, hbox2, hbox3);
        boxDinamico.setStyle("-fx-border-color: red" );

        b.setOnAction(event -> {
            try {
                if (textField1.getText().isEmpty() || datePicker.getValue() == null || passwordField.getText().isEmpty()) {
                    throw new DatosIncompletosException("Por favor complete todos los campos de la tarjeta.");
                }
            } catch (DatosIncompletosException e) {
                mostrarErrorPopup(e.getMessage());
            }
        });
        
    }


    public boolean verificarProm() {
        String codigo = txtProm.getText().trim();
        boolean bo = false;

        if (!codigo.isEmpty()) {
            for (Promocion p : promociones) {
                if (codigo.equals(p.getCodigo()) && p.getPais().equals(ReservarController.origen)) {
                    bo = true;
                    descuento = p.getDescuento();
                    break;
                }
            }
        } else {
            descuento = 0;
            bo = true;
        }

        return bo;
    }


    
    public void detallesbox(){
        valorantes = (TarifaController.precioVTIDA + TarifaRegresoController.precioVTREGRESO);
        Label valor = new Label("Resumen de compra: " + valorantes);
        valor.setFont(Font.font("System", FontWeight.BOLD, 12));
        
        Label descuentolbl = new Label("Descuento: " + descuento);
        descuentolbl.setFont(Font.font("System", FontWeight.BOLD, 12));
        
        valordespues = (valorantes*descuento)/100 +valorantes;
        Label total = new Label("Precio Final: " + valordespues);
        total.setFont(Font.font("System", FontWeight.BOLD, 12));
        
        boxDetalles.getChildren().addAll(valor,descuentolbl,total);
        boxDetalles.setAlignment(Pos.CENTER_RIGHT);
        
    }
    
    
    public void cancelar(){
        Stage stage = (Stage) c.getScene().getWindow();
        
        Stage popupStage = new Stage();
        popupStage.initModality(Modality.APPLICATION_MODAL);
        popupStage.setTitle("Ventana Emergente");
        Label aviso = new Label("DESEAS CANCELAR LA RESERVA?");
        Button closeButton = new Button("Cerrar");
        closeButton.setOnAction(e -> popupStage.close());
        closeButton.setOnAction(e -> stage.close());
        
        VBox popupRoot = new VBox(100);
        popupRoot.getChildren().addAll(aviso,closeButton);
        popupRoot.setAlignment(Pos.CENTER);
        
        Scene popupScene = new Scene(popupRoot, 300, 300);
        popupStage.setScene(popupScene);
        
        popupStage.showAndWait();
    }
    
    public void confirmar(){
        try {
            
            Stage s = (Stage) b.getScene().getWindow();
            s.close();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Confirmacion.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private void mostrarErrorPopup(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Campos Incompletos");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
     
    private void mostrarErrorPopup2(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error en Código de Promoción");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
     
     
     
}
