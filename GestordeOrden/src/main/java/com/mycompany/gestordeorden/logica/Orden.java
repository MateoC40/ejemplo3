package com.mycompany.gestordeorden.logica;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 * Entidad Orden: representa una orden con varias líneas de pedido.
 */
@Entity
public class Orden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identificador;

    // Una orden tiene muchas líneas de pedido.
    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LineaPedido> lineasPedido = new ArrayList<>();

    // Constructor vacío requerido por JPA
    public Orden() {
    }

    public Orden(int identificador) {
        this.identificador = identificador;
    }

    // Getter para el identificador
    public int getIdentificador() {
        return identificador;
    }

    // Setter para el identificador
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Este método te permite obtener la lista de líneas de pedido asociadas a
     * la orden. ¡Este método es el que elimina el error del IDE!
     */
    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    /**
     * Permite reemplazar la lista de líneas de pedido completa.
     */
    public void setLineasPedido(List<LineaPedido> lineasPedido) {
        this.lineasPedido = lineasPedido;
    }

    /**
     * Agrega una línea de pedido a la orden y asegura la relación
     * bidireccional.
     */
    public void añadiritem(int identificador, int cantidad, Producto producto) {
        // Creamos una nueva línea de pedido
        LineaPedido linea = new LineaPedido();
        linea.setCantidad(cantidad);
        linea.setProducto(producto);
        linea.setOrden(this); // asignamos la orden actual

        // Añadimos la línea a la lista interna de la orden
        this.lineasPedido.add(linea);
    }

    /**
     * Suma los subtotales de cada línea de pedido.
     */
    public int calcularTotal() {
        return lineasPedido.stream()
                .mapToInt(LineaPedido::calcularSubtotal)
                .sum();
    }

    @Override
    public String toString() {
        return "Orden{"
                + "identificador=" + identificador
                + ", lineasPedido=" + lineasPedido
                + ", total=" + calcularTotal()
                + '}';
    }
}
