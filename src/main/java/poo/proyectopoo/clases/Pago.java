/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poo.proyectopoo.clases;

/**
 *
 * @author flsan
 */
public class Pago {
    int idPago;
    String codigoReserva;
    double totalReserva;
    double descuento;
    String tipoPago;
    double totalPagar;

    public Pago(int idPago, String codigoReserva, double totalReserva, double descuento, String tipoPago, double totalPagar) {
        this.idPago = idPago;
        this.codigoReserva = codigoReserva;
        this.totalReserva = totalReserva;
        this.descuento = descuento;
        this.tipoPago = tipoPago;
        this.totalPagar = totalPagar;
    }

    

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public double getTotalReserva() {
        return totalReserva;
    }

    public void setTotalReserva(double totalReserva) {
        this.totalReserva = totalReserva;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    @Override
    public String toString() {
        return "Pago{" + "idPago=" + idPago + ", codigoReserva=" + codigoReserva + ", totalReserva=" + totalReserva + ", descuento=" + descuento + ", tipoPago=" + tipoPago + ", totalPagar=" + totalPagar + '}';
    }

    
    
    
    




}
