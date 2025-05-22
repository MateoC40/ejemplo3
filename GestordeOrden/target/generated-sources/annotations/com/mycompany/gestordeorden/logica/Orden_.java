package com.mycompany.gestordeorden.logica;

import com.mycompany.gestordeorden.logica.LineaPedido;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-22T16:54:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Orden.class)
public class Orden_ { 

    public static volatile ListAttribute<Orden, LineaPedido> lineasPedido;
    public static volatile SingularAttribute<Orden, Integer> identificador;

}