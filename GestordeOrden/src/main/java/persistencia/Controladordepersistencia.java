/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

/**
 *
 * @author USUARIO
 */
import com.mycompany.gestordeorden.logica.Orden;
import com.mycompany.gestordeorden.logica.Lineapedido;
import com.mycompany.gestordeorden.logica.Producto;
import com.mycompany.gestordeorden.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Controladordepersistencia {
    
    LineapedidoJpaController LJPA= new LineapedidoJpaController(); 
    OrdenJpaController OJPA= new OrdenJpaController(); 
    ProductoJpaController PJPA= new ProductoJpaController(); 
    
    
        // Métodos para Orden
    public void crearOrden(Orden al) {
        OJPA.create(al);
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

    public void editarOrden(Orden al) {
        try {
            OJPA.edit(al);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Lineapedido
    public void crearLineapedido(Lineapedido car) {
        LJPA.create(car);
    }

    public Lineapedido buscarLineapedido(int id) {
        return LJPA.findLineapedido(id);
    }

    public List<Lineapedido> listarLineapedidos() {
        return LJPA.findLineapedidoEntities();
    }

    public void eliminarLineapedido(int id) {
        try {
            LJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarLineapedido(Lineapedido car) {
        try {
            LJPA.edit(car);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Métodos para Producto
public void crearProducto(Producto mat) {
    try {
        PJPA.create(mat);
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

    public void editarProducto(Producto mat) {
        try {
            PJPA.edit(mat);
        } catch (Exception ex) {
            Logger.getLogger(Controladordepersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
