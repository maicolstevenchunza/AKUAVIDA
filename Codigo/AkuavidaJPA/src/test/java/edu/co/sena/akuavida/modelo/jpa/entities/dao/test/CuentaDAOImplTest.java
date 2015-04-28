/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.entitis.CuentaPK;
import edu.co.sena.akuavida.modelo.entitis.Usuario;
import edu.co.sena.akuavida.modelo.factory.DAOAbstractFactory;
import edu.co.sena.akuavida.modelo.factory.DAOFactory;
import edu.co.sena.akuavida.modelo.factory.mysql.MysqlJPADAOFactory;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.CuentaDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.interfaces.ICuentaDAO;
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
        entity.setCuentaPK(new CuentaPK("C.C", "10337576329"));
        entity.setPrimerNombre("Miguel");
        entity.setSegundoNombre("Angel");
        entity.setPrimerApellido("Montero");
        entity.setSegundoApellido("Bogota");
        entity.setDireccion("Calle $9 G # 6 A 29 Sur");
        entity.setTelefono("3134194242");
        entity.setRool("Usuario");
        entity.setActivo(true);
        entity.setUsuarioidUsuario(new Usuario("Usuariolool"));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        ejemplo.insert(entity);

    }

    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        Cuenta ct = ejemplo.finByCuentaPk(new CuentaPK("C.C", "1033757632"));
        ct.setTelefono("7605996");
        ejemplo.update(ct);
    }

    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        Cuenta ct = ejemplo.finByCuentaPk(new CuentaPK("C.C", "1033757632"));
        ejemplo.delete(entity);
    }

    @Test
    public void testFinByCuentaPk() throws Exception {
        System.out.println("finByCuentaPk");
        Cuenta ct;
        String tipoDocumento = "C.C";
        String numerodocumento = "1033757632";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        ct = ejemplo.finByCuentaPk(new CuentaPK(tipoDocumento, numerodocumento));
        System.out.println(ct.toString());
    }

    @Test
    public void testFindByAll() throws Exception {
        System.out.println("findByAll");
       DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findByAll();
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByPrimerNombre() throws Exception {
        System.out.println("findByPrimerNombre");
        String primerNombre = "Miguel";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findByPrimerNombre(primerNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindBySegundoNombre() throws Exception {
        System.out.println("findBySegundoNombre");
        String segundoNombre = "Angel";
       DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findBySegundoNombre(segundoNombre);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByPrimerApellido() throws Exception {
        System.out.println("findByPrimerApellido");
        String primerApellido = "Montero";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findByPrimerApellido(primerApellido);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindBySegundoApellido() throws Exception {
        System.out.println("findBySegundoApellido");
        String segundoApellido = "Bogota";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findBySegundoApellido(segundoApellido);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByDireccion() throws Exception {
        System.out.println("findByDireccion");
        String direccion = "Calle $9 G # 6 A 29 Sur";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findByDireccion(direccion);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByTelefono() throws Exception {
        System.out.println("findByTelefono");
        String telefono = "3134194242";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findByTelefono(telefono);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByRool() throws Exception {
        System.out.println("findByRool");
        String rool = "Usuario";
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findByRool(rool);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }

    @Test
    public void testFindByActivo() throws Exception {
        System.out.println("findByActivo");
        boolean activo = true;
        DAOFactory fabrica = MysqlJPADAOFactory.getDAOFactory(DAOAbstractFactory.MYSQL_FACTORY);
        ICuentaDAO ejemplo = fabrica.createCuentaDAO();
        List<Cuenta> result = ejemplo.findByActivo(activo);
        for (Cuenta result1 : result) {
            System.out.println(result1.toString());
        }
    }
}
