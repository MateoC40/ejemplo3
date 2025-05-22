/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.mycompany.gestordeorden.logica.Orden;
import com.mycompany.gestordeorden.logica.LineaPedido;
import com.mycompany.gestordeorden.logica.Producto;
import com.mycompany.gestordeorden.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USUARIO
 */


public class Controladordepersistencia {

    LineapedidoJpaController LJPA = new LineapedidoJpaController();
    OrdenJpaController OJPA = new OrdenJpaController();
    ProductoJpaController PJPA = new ProductoJpaController();

    // Métodos para Orden
    public void crearOrden(Orden or) {
        try {
            OJPA.create(or);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Orden buscarOrden(int id) {
        return OJPA.findOrden(id);
    }

    public List<Orden> listarOrdenes() {
        return OJPA.findOrdenEntities();
    }

    public void eliminarOrden(int id) {
        try {
            OJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarOrden(Orden or) {
        try {
            OJPA.edit(or);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para LineaPedido
    public void crearLineapedido(LineaPedido lp) {
        try {
            LJPA.create(lp);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public LineaPedido buscarLineapedido(int id) {
        return LJPA.findLineapedido(id);
    }

    public List<LineaPedido> listarLineapedidos() {
        return LJPA.findLineapedidoEntities();
    }

    public void eliminarLineapedido(int id) {
        try {
            LJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLineapedido(LineaPedido lp) {
        try {
            LJPA.edit(lp);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Producto
    public void crearProducto(Producto prod) {
        try {
            PJPA.create(prod);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Producto buscarProducto(int id) {
        return PJPA.findProducto(id);
    }

    public List<Producto> listarProductos() {
        return PJPA.findProductoEntities();
    }

    public void eliminarProducto(int id) {
        try {
            PJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarProducto(Producto prod) {
        try {
            PJPA.edit(prod);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}