/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestordeorden.logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author USUARIO
 */
@Entity
public class Lineapedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identificador;
    
    @Basic
    private int cantidad;

    
    
    @ManyToOne
    private Producto producto;
    
    
    
    public Lineapedido() {

    }

    public Lineapedido(int identificador, int cantidad, Producto producto) {
        this.identificador = identificador;
        this.cantidad = cantidad;
        this.producto = producto;
    }





    public int getIdentificador() {
        return identificador;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
}
