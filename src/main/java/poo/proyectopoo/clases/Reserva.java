/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Sebastian. B
 */
public class Reserva {
    String cedCliente,ciuOrig,ciuDesti,FechaSalida,FechaRegreso,CodReserva,numVueloIda,numVueloRegreso;
    int numPasajeros;
    double tarifaIda,tarifaRegreso;
    Cliente cli;
    public static ArrayList<Reserva> Reservas= new ArrayList<>();
    
    public Reserva(String ciuOrig,String ciuDesti,String FechaSalida,String FechaRegreso,int numPasajeros){
        this.ciuOrig=ciuOrig;
        this.ciuDesti=ciuDesti;
        this.FechaSalida=FechaSalida;
        this.FechaRegreso=FechaRegreso;
        this.numPasajeros=numPasajeros;
    }
    
    public Reserva(String codReserva,Cliente cli,String ciuOrig,String ciuDesti,String FechaSalida,String FechaRegreso,int numPasajeros,String numVueloIda,String numVueloRegreso,double tarifaIda,double tarifaRegreso){
        super();
        this.CodReserva=codReserva;
        this.cli=cli;
        this.cedCliente=cli.getCedula();
        this.numVueloIda=numVueloIda;
        this.numVueloRegreso=numVueloRegreso;
        this.tarifaIda=tarifaIda;
        this.tarifaRegreso=tarifaRegreso;
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
        return CodReserva+","+cedCliente+","+ciuOrig+","+ciuDesti+","+FechaSalida+","+FechaRegreso+","+numPasajeros+","+ numVueloIda+","+numVueloRegreso+","+tarifaIda+","+ tarifaRegreso;
    }
}
