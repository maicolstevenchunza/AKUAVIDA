package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.entitis.DomicilioPK;
import edu.co.sena.akuavida.modelo.entitis.Municipio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-28T19:25:30")
@StaticMetamodel(Domicilio.class)
public class Domicilio_ { 

    public static volatile SingularAttribute<Domicilio, String> direccion;
    public static volatile SingularAttribute<Domicilio, DomicilioPK> domicilioPK;
    public static volatile SingularAttribute<Domicilio, String> ciudad;
    public static volatile SingularAttribute<Domicilio, String> telefono;
    public static volatile SingularAttribute<Domicilio, Cuenta> cuenta;
    public static volatile SingularAttribute<Domicilio, Municipio> municipioidMunicipio;

}