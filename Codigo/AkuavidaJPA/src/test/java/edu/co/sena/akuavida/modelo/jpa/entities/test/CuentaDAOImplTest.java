/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.entitis.CuentaPK;
import edu.co.sena.akuavida.modelo.entitis.Usuario;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CuentaDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.util.EntityManagerHelper;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author toshiba_
 */
public class CuentaDAOImplTest {

    Cuenta entity;

    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    public CuentaDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        entity = new Cuenta();
        entity.setCuentaPK(new CuentaPK("C.C", "1033757632"));
        entity.setPrimerNombre("Miguel");
        entity.setSegundoNombre("Angel");
        entity.setPrimerApellido("Montero");
        entity.setSegundoApellido("Bogota");
        entity.setDireccion("Calle $9 G # 6 A 29 Sur");
        entity.setTelefono("3134194242");
        entity.setRool("Usuario");
        entity.setActivo(true);
        entity.setUsuarioidUsuario(new Usuario("Usuario8"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        instance.insert(entity);

    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        Cuenta ct = instance.finByCuentaPk(new CuentaPK("C.C", "1033757632"));
        ct.setTelefono("7605996");
        instance.update(ct);
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        Cuenta ct = instance.finByCuentaPk(new CuentaPK("C.C", "1033757632"));
        instance.delete(entity);
    }

    @Test
    public void testFinByCuentaPk() {
        System.out.println("finByCuentaPk");
        Cuenta ct;
        String tipoDocumento = "C.C";
        String numerodocumento = "1033757632";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        ct = instance.finByCuentaPk(new CuentaPK(tipoDocumento, numerodocumento));
        System.out.println(ct.toString());
    }

    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByAll();
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByPrimerNombre() {
        System.out.println("findByPrimerNombre");
        String primerNombre = "Miguel";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByPrimerNombre(primerNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindBySegundoNombre() {
        System.out.println("findBySegundoNombre");
        String segundoNombre = "Angel";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findBySegundoNombre(segundoNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByPrimerApellido() {
        System.out.println("findByPrimerApellido");
        String primerApellido = "Montero";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByPrimerApellido(primerApellido);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindBySegundoApellido() {
        System.out.println("findBySegundoApellido");
        String segundoApellido = "Bogota";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findBySegundoApellido(segundoApellido);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByDireccion() {
        System.out.println("findByDireccion");
        String direccion = "Calle $9 G # 6 A 29 Sur";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByDireccion(direccion);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByTelefono() {
        System.out.println("findByTelefono");
        String telefono = "3134194242";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByTelefono(telefono);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByRool() {
        System.out.println("findByRool");
        String rool = "Usuario";
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByRool(rool);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByActivo() {
        System.out.println("findByActivo");
        boolean activo = true;
        CuentaDAOImpl instance = new CuentaDAOImpl();
        List<Cuenta> result = instance.findByActivo(activo);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
