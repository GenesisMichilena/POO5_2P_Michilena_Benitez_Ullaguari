/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author flsan
 */
public class Vuelo implements Comparable<Vuelo>{
    private String numeroVuelo,origen,destino,horaSalida,horaLlegada,codigoAvion;
    private double precio;
    private int duracion;

    public Vuelo(String numeroVuelo, String origen, String destino, int duracion, String horaSalida, String horaLlegada, String codigoAvion, double precio) {
        this.numeroVuelo = numeroVuelo;
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.codigoAvion = codigoAvion;
        this.precio = precio;
    }

    public String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getCodigoAvion() {
        return codigoAvion;
    }

    public void setCodigoAvion(String codigoAvion) {
        this.codigoAvion = codigoAvion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Vuelo{" + "numeroVuelo=" + numeroVuelo + ", origen=" + origen + ", destino=" + destino + ", duracion=" + duracion + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + ", codigoAvion=" + codigoAvion + ", precio=" + precio + '}';
    }
    
    public static ArrayList<Vuelo> leerArchivoVuelos(String nombreArchivo) {
        ArrayList<Vuelo> listaVuelos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            br.readLine();
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 8) {
                    Vuelo vuelo = new Vuelo(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], datos[5], datos[6], Double.parseDouble(datos[7]));

                    listaVuelos.add(vuelo);
                } else {
                    System.out.println("Error en el formato de la línea: " + linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listaVuelos;
    }

    public int compareTo(Vuelo v, String a) {
        switch (a.toLowerCase()) {
            case "precio":
                return Double.compare(this.precio, v.precio);
            case "duracion":
                return Integer.compare(this.duracion, v.duracion);
            default:
                throw new IllegalArgumentException("Propiedad no válida para la comparación");
        }
    }

    @Override
    public int compareTo(Vuelo o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
