/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestordeorden.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author USUARIO
 */
@Entity
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identificador;

    @Basic

    private int precio;
    private String nombre;
    private String descripcion;


    public Producto() {

    }

    public Producto(int identificador, int precio, String nombre, String descripcion) {
        this.identificador = identificador;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        
    }



    public int getIdentificador() {
        return identificador;
    }

    public int getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
