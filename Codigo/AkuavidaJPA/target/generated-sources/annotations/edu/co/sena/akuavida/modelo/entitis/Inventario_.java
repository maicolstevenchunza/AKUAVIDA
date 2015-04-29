package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.InventarioPK;
import edu.co.sena.akuavida.modelo.entitis.Producto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-28T19:25:30")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, InventarioPK> inventarioPK;
    public static volatile SingularAttribute<Inventario, Float> cantidadProductoComprado;
    public static volatile SingularAttribute<Inventario, Date> fechaDeCompra;
    public static volatile SingularAttribute<Inventario, Producto> producto;

}