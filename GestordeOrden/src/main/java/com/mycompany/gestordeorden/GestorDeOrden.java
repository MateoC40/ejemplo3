package com.mycompany.gestordeorden;

import com.mycompany.gestordeorden.logica.LineaPedido;
import com.mycompany.gestordeorden.logica.Orden;
import com.mycompany.gestordeorden.logica.Producto;
import persistencia.Controladordepersistencia;

public class GestorDeOrden {

    public static void main(String[] args) {
        Controladordepersistencia controlador = new Controladordepersistencia();

        // Crear productos
        Producto pan = new Producto();
        pan.setNombre("Pan");
        pan.setPrecio(4);

        Producto queso = new Producto();
        queso.setNombre("Queso");
        queso.setPrecio(14);

        Producto arroz = new Producto();
        arroz.setNombre("Arroz");
        arroz.setPrecio(5);

        // Crear orden
        Orden orden = new Orden();

        // Añadir items a la orden usando el método añadiritem de Orden
        orden.añadiritem(orden.getIdentificador(), 5, pan);    // 5 unidades de pan
        orden.añadiritem(orden.getIdentificador(), 3, queso);  // 3 unidades de queso
        orden.añadiritem(orden.getIdentificador(), 6, arroz);  // 6 unidades de arroz

        // Calcular total
        int total = orden.calcularTotal();

        // Mostrar detalle de cada línea
        System.out.println("Detalle de la orden:");
        for (LineaPedido lp : orden.getLineasPedido()) {
            int subtotalLinea = lp.getProducto().getPrecio() * lp.getCantidad();
            System.out.println(lp.getProducto().getNombre() + " (" + lp.getCantidad() + " unidades) total " + subtotalLinea);
        }

        // Mostrar total
        System.out.println("Total general: " + total);
    }
}
