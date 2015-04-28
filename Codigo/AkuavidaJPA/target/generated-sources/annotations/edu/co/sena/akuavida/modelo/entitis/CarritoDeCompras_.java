package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarrito;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-28T10:04:31")
@StaticMetamodel(CarritoDeCompras.class)
public class CarritoDeCompras_ { 

    public static volatile SingularAttribute<CarritoDeCompras, Float> total;
    public static volatile SingularAttribute<CarritoDeCompras, String> iDCarrito;
    public static volatile SingularAttribute<CarritoDeCompras, Float> subtotal;
    public static volatile CollectionAttribute<CarritoDeCompras, ItemsDelCarrito> itemsDelCarritoCollection;

}