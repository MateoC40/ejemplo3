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
 * 
 * 1 a 1 lineas de pedido producto
 * 1 a muchos orden a lineapedido
 * 
 * 
 */
@Entity
public class Orden implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int identificador;

    @OneToMany(mappedBy = "lineapedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Lineapedido> lineapedido;
    

    public Orden() {

    }

    public Orden(int identificador,Lineapedido lineapedido ) {
        this.identificador = identificador;
        this.lineapedido = (List<Lineapedido>) lineapedido ;
        
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    

}
