package com.mycompany.gestordeorden.logica;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entidad que representa una línea de pedido, asociada a un producto y una orden.
 */
@Entity
public class LineaPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identificador;

    @Basic
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private Orden orden;

    // Constructor vacío requerido por JPA
    public LineaPedido() {}

    /**
     * Constructor para crear una línea de pedido con cantidad, producto y orden.
     */
    public LineaPedido(int cantidad, Producto producto, Orden orden) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.orden = orden;
    }

    // Getter y setter para identificador
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    // Getter y setter para cantidad
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Getter y setter para producto
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // Getter para orden
    public Orden getOrden() {
        return orden;
    }

    // **ESTE ES EL MÉTODO QUE SOLUCIONA TU ERROR**
    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    // Calcula el subtotal: cantidad * precio del producto
    public int calcularSubtotal() {
        if (producto != null) {
            return cantidad * producto.getPrecio();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "LineaPedido{" +
                "identificador=" + identificador +
                ", cantidad=" + cantidad +
                ", producto=" + (producto != null ? producto.getNombre() : "null") +
                ", subtotal=" + calcularSubtotal() +
                '}';
    }
}