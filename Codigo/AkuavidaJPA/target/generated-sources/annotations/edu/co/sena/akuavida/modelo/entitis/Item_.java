package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.ItemPK;
import edu.co.sena.akuavida.modelo.entitis.Pedido;
import edu.co.sena.akuavida.modelo.entitis.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-28T19:25:30")
@StaticMetamodel(Item.class)
public class Item_ { 

    public static volatile SingularAttribute<Item, Float> costoTotal;
    public static volatile SingularAttribute<Item, Integer> cantidad;
    public static volatile SingularAttribute<Item, Producto> producto;
    public static volatile SingularAttribute<Item, Pedido> pedido;
    public static volatile SingularAttribute<Item, Float> costoUnitario;
    public static volatile SingularAttribute<Item, ItemPK> itemPK;

}