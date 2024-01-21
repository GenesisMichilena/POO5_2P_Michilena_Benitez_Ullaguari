/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Sebastian. B
 */
public class Cliente {
    private String cedula,nombre,apellido,usuario,contrasena;
    public static ArrayList<Cliente> clientes= new ArrayList<>();
    
    public Cliente(String cedula,String nombre,String apellido,String usuario,String contrasena){
        this.cedula=cedula;
        this.nombre=nombre;
        this.apellido=apellido;
        this.usuario=usuario;
        this.contrasena=contrasena;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getContrasena(){
        return contrasena;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public String getCedula(){
        return cedula;
    }
    @Override
    public String toString(){
        return this.cedula+","+this.nombre+","+this.apellido+","+this.usuario+","+this.contrasena;
    }
    public static void agregarClienteFinal(String contenido) {
        try {            
            FileWriter fw = new FileWriter("Clientes.txt", true);
            fw.write("\n");
            fw.write(contenido);            
            fw.close();
        }catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void lecturaClientes(){
        
        try{
            BufferedReader bf= new BufferedReader(new FileReader("Clientes.txt"));            
            String linea;
            while((linea=bf.readLine())  !=null){               
               String[] cli= linea.split(",");
               Cliente cliente= new Cliente(cli[0],cli[1],cli[2],cli[3],cli[4]);
               clientes.add(cliente);
               
            }bf.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){
          System.out.println("Inconvenitente con el indice de Array");
        }
    }
    
}
