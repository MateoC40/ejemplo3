package com.mycompany.gestordeorden.logica;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identificador;

    @Basic
    private String nombre;

    @Basic
    private int precio;

    // Constructor vacío requerido por JPA
    public Producto() {}

    // Constructor que necesitas para tu main
    public Producto(int identificador, String nombre, int precio) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "identificador=" + identificador +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}