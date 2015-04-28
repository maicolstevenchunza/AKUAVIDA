package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.Categorias;
import edu.co.sena.akuavida.modelo.entitis.Inventario;
import edu.co.sena.akuavida.modelo.entitis.Item;
import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarrito;
import edu.co.sena.akuavida.modelo.entitis.Promociones;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-28T10:04:31")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, String> iDproducto;
    public static volatile SingularAttribute<Producto, byte[]> imagen;
    public static volatile CollectionAttribute<Producto, Promociones> promocionesCollection;
    public static volatile CollectionAttribute<Producto, Inventario> inventarioCollection;
    public static volatile SingularAttribute<Producto, Float> precio;
    public static volatile SingularAttribute<Producto, Integer> cantidad;
    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile SingularAttribute<Producto, Categorias> categoriasIDCategoria;
    public static volatile CollectionAttribute<Producto, Item> itemCollection;
    public static volatile SingularAttribute<Producto, Float> impuesto;
    public static volatile SingularAttribute<Producto, Boolean> activo;
    public static volatile CollectionAttribute<Producto, ItemsDelCarrito> itemsDelCarritoCollection;

}