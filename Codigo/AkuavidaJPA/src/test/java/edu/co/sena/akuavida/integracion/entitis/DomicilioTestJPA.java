/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.integracion.entitis;

import edu.co.sena.akuavida.integracion.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ColsutecR
 */
public class DomicilioTestJPA {

    Domicilio domicilio;

    EntityManagerFactory emf;
    EntityManager em;

    public DomicilioTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        domicilio = new Domicilio();
        domicilio.setMunicipioidMunicipio(new Municipio("2000"));
        domicilio.setDomicilioPK(new DomicilioPK("C.C", "1033790199"));
        domicilio.setCiudad("El Bronx");
        domicilio.setDireccion("Calle 49 G # 6 A 29 sur ");
        domicilio.setTelefono("3217915742");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void insertarDomicilio() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(domicilio);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarDomicilio() {

        String idTD = JOptionPane.showInputDialog("Escriba el tipo de documento");
        String idND = JOptionPane.showInputDialog("Escriba el numero de documento");
        String actTele = JOptionPane.showInputDialog("Escriba El Telefono");

        domicilio.setCuenta(new Cuenta(idTD, idND));
        domicilio.setTelefono(actTele);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(domicilio);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnDomicilio() {
        String idTD = JOptionPane.showInputDialog("Escriba el tipo de documento");
        String idND = JOptionPane.showInputDialog("Escriba el numero de documento");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Domicilio domi = em.find(Domicilio.class, new DomicilioPK(idTD, idND));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(domi.toString());
    }

    @Test
    public void borrarUnaFactura() {
        String idTD = JOptionPane.showInputDialog("Escriba el tipo de documento");
        String idND = JOptionPane.showInputDialog("Escriba el numero de documento");

        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Domicilio.class, new DomicilioPK(idTD, idND)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se puedo eliminar el domicilio" + e.getMessage());
        }

    }

    @Test
    public void buscarDomicilios() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Domicilio.findAll");
        List<Domicilio> lis = q.getResultList();
        for (Domicilio domicilioT : lis) {

            System.out.println(domicilioT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorCiudad() {
        String ciudad = JOptionPane.showInputDialog("Insertar la ciudad");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Domicilio.findByCiudad");
        query.setParameter("ciudad", ciudad);

        Domicilio municipioT = (Domicilio) query.getSingleResult();

        List<Domicilio> lis = query.getResultList();
        for (Domicilio domicilioT : lis) {

            System.out.println(domicilioT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    @Test
    public void buscarPorDireccion() {
        String direccion = JOptionPane.showInputDialog("Insertar la direccion");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Domicilio.findByDireccion");
        query.setParameter("direccion", direccion);

        Domicilio municipioT = (Domicilio) query.getSingleResult();

        List<Domicilio> lis = query.getResultList();
        for (Domicilio domicilioT : lis) {

            System.out.println(domicilioT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
    @Test
    public void buscarPorTelefono() {
        String telefono = JOptionPane.showInputDialog("Insertar el telefono");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Domicilio.findByTelefono");
        query.setParameter("telefono", telefono);

        Domicilio domicilioTem = (Domicilio) query.getSingleResult();

        List<Domicilio> lis = query.getResultList();
        for (Domicilio domicilioT : lis) {

            System.out.println(domicilioT.toString());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }
}
