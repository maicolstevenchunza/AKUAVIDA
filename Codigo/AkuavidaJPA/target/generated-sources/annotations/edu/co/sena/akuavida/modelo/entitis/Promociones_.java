package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-27T20:20:55")
@StaticMetamodel(Promociones.class)
public class Promociones_ { 

    public static volatile SingularAttribute<Promociones, Float> descuentos;
    public static volatile SingularAttribute<Promociones, Float> precio;
    public static volatile SingularAttribute<Promociones, Producto> productoIDproducto;
    public static volatile SingularAttribute<Promociones, String> idPromocion;
    public static volatile SingularAttribute<Promociones, String> nombre;

}