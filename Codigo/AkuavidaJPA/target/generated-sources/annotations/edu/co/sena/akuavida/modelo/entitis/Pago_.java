package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-27T20:52:01")
@StaticMetamodel(Pago.class)
public class Pago_ { 

    public static volatile SingularAttribute<Pago, Factura> factura;
    public static volatile SingularAttribute<Pago, String> tipoPago;
    public static volatile SingularAttribute<Pago, Integer> facturaIDFactura;
    public static volatile SingularAttribute<Pago, String> numeroTarjeta;

}