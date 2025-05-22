package com.mycompany.gestordeorden.logica;

import com.mycompany.gestordeorden.logica.Orden;
import com.mycompany.gestordeorden.logica.Producto;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-05-22T16:54:33", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(LineaPedido.class)
public class LineaPedido_ { 

    public static volatile SingularAttribute<LineaPedido, Integer> cantidad;
    public static volatile SingularAttribute<LineaPedido, Producto> producto;
    public static volatile SingularAttribute<LineaPedido, Orden> orden;
    public static volatile SingularAttribute<LineaPedido, Integer> identificador;

}