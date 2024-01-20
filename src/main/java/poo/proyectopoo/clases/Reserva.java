/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sebastian. B
 */
public class Reserva {
    Cliente cliente;
    String ciuOrig,ciuDesti,FechaSalida,FechaRegreso,CodReserva,numVueloIda,numVueloRegreso;
    int numPasajeros;
    double tarifaIda,tarifaRegreso;

    public Reserva(Cliente cliente, String ciuOrig, String ciuDesti, String FechaSalida, String FechaRegreso, String CodReserva, String numVueloIda, String numVueloRegreso, int numPasajeros, double tarifaIda, double tarifaRegreso) {
        this.cliente = cliente;
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
    public String toString() {
        return  cliente.getNombre() + "-" + CodReserva;
    }
    
    
}
