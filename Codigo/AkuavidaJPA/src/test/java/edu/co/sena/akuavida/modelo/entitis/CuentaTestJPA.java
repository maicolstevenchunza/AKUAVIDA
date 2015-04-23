/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.entitis;

import edu.co.sena.akuavida.modelo.entitis.CuentaPK;
import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.entitis.Usuario;
import edu.co.sena.akuavida.modelo.entitis.CarritoDeCompras;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
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
public class CuentaTestJPA {

    Cuenta cuenta;

    EntityManagerFactory emf;
    EntityManager em;

    public CuentaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        cuenta = new Cuenta();
        cuenta.setCuentaPK(new CuentaPK("C.C", "1033790199"));
        cuenta.setPrimerNombre("Juan");
        cuenta.setSegundoNombre("David");
        cuenta.setPrimerApellido("Montero");
        cuenta.setSegundoApellido("Bogota");
        cuenta.setDireccion("Calle 49 G # 6 A 29 sur ");
        cuenta.setTelefono("3217915742");
        cuenta.setRool("Cliente");
        cuenta.setActivo(true);
        cuenta.setUsusarioidUsusario(new Usuario("1"));
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
    public void insertarCuenta() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(cuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void actualizarCuenta() {

        String idTD = JOptionPane.showInputDialog("Escriba el tipo de documento");
        String idND = JOptionPane.showInputDialog("Escriba el numero de documento");
        String actSeg_Nom = JOptionPane.showInputDialog("Escriba El Nombre");
        String actTele = JOptionPane.showInputDialog("Escriba El Telefono");

        cuenta.setCuentaPK(new CuentaPK(idTD, idND));
        cuenta.setSegundoNombre(actSeg_Nom);
        cuenta.setTelefono(actTele);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(cuenta);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnaCuenta() {

        String idTd = JOptionPane.showInputDialog("Inserte El Tipo Documento");
        String idNd = JOptionPane.showInputDialog("Inserte El Numero Documento");
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Cuenta cue = em.find(Cuenta.class, new CuentaPK(idTd, idNd));
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(cue.toString());
    }

    @Test
    public void borrarUnaCuenta() {
        String idTd = JOptionPane.showInputDialog("Inserte El Tipo Documento");
        String idNd = JOptionPane.showInputDialog("Inserte El Numero Documento");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(CarritoDeCompras.class, new CuentaPK(idTd, idNd)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();

        } catch (Exception e) {
            System.out.println("No se pudo eliminar la cuenta" + e.getMessage());
        }

    }

    @Test
    public void buscarCuentas() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Cuenta.findAll");
        List<Cuenta> lis = q.getResultList();
        for (Cuenta cuentaT : lis) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido() +  " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void actualizarPkCuenta() {
        em = EntityManagerHelper.getEntityManager();
        String idTd = JOptionPane.showInputDialog("Digite El Tipo de Documento a actualizar");
        String idNd = JOptionPane.showInputDialog("Digite El numero de Documento a actualizar");
        String nuevoTd = JOptionPane.showInputDialog("Digite El nuevo Tipo de Documento a actualizar");
        String nuevoNd = JOptionPane.showInputDialog("Digite El nuevo numero de Documento a actualizar");

        String sql = "UPDATE `akuavida`.`cuenta`"
                + "SET"
                + "`Tipo_Documento` = '" + nuevoTd + "', "
                + "`Numero_Documento` = '" + nuevoNd + "'"
                + "WHERE `Tipo_Documento` = '" + idTd + "' AND `Numero_Documento` = '" + idNd + "';";

        System.out.println(sql);
        Query query = em.createNativeQuery(sql);
        EntityManagerHelper.beginTransaction();
        int rowCount = query.executeUpdate();
        System.out.println("Se actualizaron " + rowCount + "Registros");
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorPrimerNombre() {
        String primerNombre = JOptionPane.showInputDialog("Insertar el primer nombre del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByPrimerNombre");
        query.setParameter("primerNombre", primerNombre);

        Cuenta pNOmbre = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido() +  " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorSegundoNombre() {
        String segundoNombre = JOptionPane.showInputDialog("Insertar el segundo nombre del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findBySegundoNombre");
        query.setParameter("segundoNombre", segundoNombre);

        Cuenta sNOmbre = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido() + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorPrimerApellido() {
        String primerApellido = JOptionPane.showInputDialog("Insertar el primer apellido del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByPrimerApellido");
        query.setParameter("primerApellido", primerApellido);

        Cuenta pApellido = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido() + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorSegundoApellido() {
        String segundoApellido = JOptionPane.showInputDialog("Insertar el segundo apellido del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findBySegundoApellido");
        query.setParameter("segundoApellido", segundoApellido);

        Cuenta sApellido = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido()  + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorCorreo() {
        String correo = JOptionPane.showInputDialog("Insertar el correo del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByCorreo");
        query.setParameter("correo", correo);

        Cuenta correoT = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido()  + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorDireccion() {
        String direccion = JOptionPane.showInputDialog("Insertar la direccion del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByDireccion");
        query.setParameter("direccio", direccion);

        Cuenta direccionT = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido()  + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorTelefono() {
        String telefono = JOptionPane.showInputDialog("Insertar el telefono del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByTelefono");
        query.setParameter("telefono", telefono);

        Cuenta telefonoT = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido()  + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorRool() {
        String rool = JOptionPane.showInputDialog("Insertar el rool del usuario");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByRool");
        query.setParameter("rool", rool);

        Cuenta roolT = (Cuenta) query.getSingleResult();

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido()  + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorActivo() {

        String activo = JOptionPane.showInputDialog("Insertar si esta activo el usuario o no");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Cuenta.findByActivo");
        query.setParameter("activo", Boolean.parseBoolean(activo));

        List<Cuenta> lista = query.getResultList();
        for (Cuenta cuentaT : lista) {
            System.out.println("Id Cuenta: " + cuentaT.getCuentaPK() + " / Primer NOmbre: " + cuentaT.getPrimerNombre() + " / Segundo Nombre: " + cuentaT.getSegundoNombre() + " / Primer Apellido: " + cuentaT.getPrimerApellido() + " / Segundo Apelido: "
                    + cuentaT.getSegundoApellido() + " / Direccion: " + cuentaT.getDireccion() + " / Telefono: " + cuentaT.getTelefono() + " / Rool: " + cuentaT.getRool() + " / Activo: " + cuentaT.getActivo() + " / Id Usuario: " + cuentaT.getUsusarioidUsusario());

        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
