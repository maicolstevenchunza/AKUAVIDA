package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.CuentaPK;
import edu.co.sena.akuavida.modelo.entitis.Domicilio;
import edu.co.sena.akuavida.modelo.entitis.Factura;
import edu.co.sena.akuavida.modelo.entitis.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-28T19:25:30")
@StaticMetamodel(Cuenta.class)
public class Cuenta_ { 

    public static volatile SingularAttribute<Cuenta, String> direccion;
    public static volatile SingularAttribute<Cuenta, Usuario> usuarioidUsuario;
    public static volatile SingularAttribute<Cuenta, String> primerApellido;
    public static volatile SingularAttribute<Cuenta, Domicilio> domicilio;
    public static volatile SingularAttribute<Cuenta, CuentaPK> cuentaPK;
    public static volatile CollectionAttribute<Cuenta, Factura> facturaCollection;
    public static volatile SingularAttribute<Cuenta, String> telefono;
    public static volatile SingularAttribute<Cuenta, String> segundoNombre;
    public static volatile SingularAttribute<Cuenta, String> rool;
    public static volatile SingularAttribute<Cuenta, Boolean> activo;
    public static volatile SingularAttribute<Cuenta, String> primerNombre;
    public static volatile SingularAttribute<Cuenta, String> segundoApellido;

}