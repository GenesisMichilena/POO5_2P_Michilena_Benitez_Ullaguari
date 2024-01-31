/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author flsan
 */
public class Tarifa {
    private String nombre,tipo;
    private String[] características;
    private Double porcentaje;

    public Tarifa(String nombre, String tipo, String[] características, Double porcentaje) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.características = características;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String[] getCaracterísticas() {
        return características;
    }

    public void setCaracterísticas(String[] características) {
        this.características = características;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return "Tarifa{" + "nombre=" + nombre + ", tipo=" + tipo + ", caracteristicas=" + Arrays.toString(características) + ", porcentaje=" + porcentaje + '}';
    }

    
    
    public static ArrayList<Tarifa> leerArchivo(String archivo){
        ArrayList<Tarifa> tarifas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(archivo))){
            br.readLine();
            String linea;
                while((linea = br.readLine()) != null){
                    String datos[] = linea.split(",");
                    String[]  c = datos[2].split("-");
                    if(datos.length == 4){
                        Tarifa t =  new Tarifa(datos[0], datos[1], c, Double.valueOf(datos[3]));
                        tarifas.add(t);
                    }else{
                        System.out.println("No tiene el formato correcto en la linea" + linea);
                    }
                }
        }catch(IOException e){
            System.out.println("No se puedo leer el archivo");
        }
        
        return tarifas;
    }
}