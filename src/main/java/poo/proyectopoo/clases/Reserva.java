/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import poo.proyectopoo.ConfirmacionController;
import poo.proyectopoo.Excepciones.Pagable;
import poo.proyectopoo.PagoController;

/**
 *
 * @author Sebastian. B
 */
public class Reserva implements Pagable, Serializable{
    String cedulaCliente,ciuOrig,ciuDesti,CodReserva,numVueloIda,numVueloRegreso;
    LocalDate FechaSalida,FechaRegreso;
    int numPasajeros;
    String tarifaIda,tarifaRegreso;

    public Reserva(String CodReserva, String cedulaCliente, String ciuOrig, String ciuDesti, LocalDate FechaSalida, LocalDate FechaRegreso, int numPasajeros, String numVueloIda, String numVueloRegreso, String tarifaIda, String tarifaRegreso) {
        this.cedulaCliente = cedulaCliente;
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
}
