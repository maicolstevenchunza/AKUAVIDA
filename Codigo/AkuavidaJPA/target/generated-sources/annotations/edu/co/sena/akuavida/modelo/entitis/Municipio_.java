package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.entitis.Domicilio;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-04-27T20:52:01")
@StaticMetamodel(Municipio.class)
public class Municipio_ { 

    public static volatile SingularAttribute<Municipio, String> nombreMunicipio;
    public static volatile SingularAttribute<Municipio, String> idMunicipio;
    public static volatile CollectionAttribute<Municipio, Domicilio> domicilioCollection;
    public static volatile SingularAttribute<Municipio, Departamento> departamentoidDepartamento;

}