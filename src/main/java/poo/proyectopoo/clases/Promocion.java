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
public class Promocion {
    private double coordenadaX,coordenadaY;
    private String pais,codigo;
    private double descuento;

    public Promocion(double coordenadaX, double coordenadaY, String codigo, String pais, double descuento) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.pais = pais;
        this.codigo = codigo;
        this.descuento = descuento;
    }

    public double getCoordenadaX() {
        return coordenadaX;
    }

    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public double getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Promocion{" + "coordenadaX=" + coordenadaX + ", coordenadaY=" + coordenadaY + ", pais=" + pais + ", codigo=" + codigo + ", descuento=" + descuento + '}';
    }

    
    
    public static ArrayList<Promocion> leerArchivo(String nomArchivo) {
        ArrayList<Promocion> p= new ArrayList<>();
        try(BufferedReader bf = new BufferedReader(new FileReader(nomArchivo))){
            bf.readLine();
            String linea;
            while((linea=bf.readLine())!= null){
                String datos []= linea.split(",");
                if (datos.length==5){
                    Promocion pr = new Promocion(Double.parseDouble(datos[0]),Double.parseDouble(datos[1]),datos[2],datos[3],Double.parseDouble(datos[4])); 
                    p.add(pr);
                }
                else{
                    System.out.println("Error en el formato de la línea: " + linea);
                }
            }
            
        }catch(IOException e){
            System.out.println("No se pudo leer el archivo");
            
        }
        
        return p;
    }
}
