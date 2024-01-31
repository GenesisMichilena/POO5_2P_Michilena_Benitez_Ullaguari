/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import poo.proyectopoo.ConfirmacionController;
import poo.proyectopoo.Excepciones.Pagable;
import poo.proyectopoo.PagoController;
>>>>>>> john

/**
 *
 * @author Sebastian. B
 */
<<<<<<< HEAD
public class Reserva {
    String cedCliente,ciuOrig,ciuDesti,FechaSalida,FechaRegreso,CodReserva,numVueloIda,numVueloRegreso;
    int numPasajeros;
    double tarifaIda,tarifaRegreso;
    Cliente cliente;
    public static ArrayList<Reserva> Reservas= new ArrayList<>();

    public Reserva(String cedCliente, String ciuOrig, String ciuDesti, String FechaSalida, String FechaRegreso, String CodReserva, String numVueloIda, String numVueloRegreso, int numPasajeros, double tarifaIda, double tarifaRegreso, Cliente cliente) {
        this.cedCliente = cedCliente;
=======
public class Reserva implements Pagable, Serializable{
    String cedulaCliente,ciuOrig,ciuDesti,CodReserva,numVueloIda,numVueloRegreso;
    LocalDate FechaSalida,FechaRegreso;
    int numPasajeros;
    String tarifaIda,tarifaRegreso;

    public Reserva(String CodReserva, String cedulaCliente, String ciuOrig, String ciuDesti, LocalDate FechaSalida, LocalDate FechaRegreso, int numPasajeros, String numVueloIda, String numVueloRegreso, String tarifaIda, String tarifaRegreso) {
        this.cedulaCliente = cedulaCliente;
>>>>>>> john
        this.ciuOrig = ciuOrig;
        this.ciuDesti = ciuDesti;
        this.FechaSalida = FechaSalida;
        this.FechaRegreso = FechaRegreso;
        this.CodReserva = CodReserva;
        this.numVueloIda = numVueloIda;
        this.numVueloRegreso = numVueloRegreso;
        this.numPasajeros = numPasajeros;
        this.tarifaIda = tarifaIda;
        this.tarifaRegreso = tarifaRegreso;
<<<<<<< HEAD
        this.cliente = cliente;
    }
     
    public void escribirArchivoReserva(Reserva re){
        File file= new File("Reserva.txt");
        try {            
            if(file.createNewFile()){
                FileWriter fw = new FileWriter("Reserva.txt", true);
                fw.write(""+re);            
                fw.write("\n");
                fw.close();
            }else{
                System.out.println("El archivo ya existe y fue escrito");
                FileWriter fw = new FileWriter("Reserva.txt", true);
                fw.write(""+re);
                fw.write("\n");
                
            }
            
        }catch (IOException e) {
            System.out.println("A ocurrido un error");
        }
    }
    @Override
    public String toString(){
        return CodReserva+","+cliente.getCedula()+","+ciuOrig+","+ciuDesti+","+FechaSalida+","+FechaRegreso+","+numPasajeros+","+ numVueloIda+","+numVueloRegreso+","+tarifaIda+","+ tarifaRegreso;
    }

=======
    }

    @Override
    public String toString() {
        return cedulaCliente + "," + ciuOrig + "," + ciuDesti + "," + FechaSalida + "," + FechaRegreso + "," + CodReserva + "," + numVueloIda + "," + numVueloRegreso + "," + numPasajeros + "," + tarifaIda + "," + tarifaRegreso ;
    }

    
    
    public static void escribirArchivoReserva(Reserva re) {
        // Ruta del archivo "Reservas.txt"
        String filePath = "Reserva.txt";
        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write(re.toString());
            fw.write("\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }


    
        Random random = new Random();
        int idPago = random.nextInt(900000) + 100000;
        
    @Override
    public Pago generarTransaccion() {
        Pago p = new Pago(idPago,ConfirmacionController.codigoReserva,PagoController.valorantes,PagoController.descuento,PagoController.tipo,PagoController.valordespues);
        Pago.escribirArchivoPago(p);
        return p;
    }
>>>>>>> john
}
