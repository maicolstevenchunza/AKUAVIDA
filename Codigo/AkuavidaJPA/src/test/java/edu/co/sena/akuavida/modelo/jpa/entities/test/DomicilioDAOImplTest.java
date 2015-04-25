/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.entitis.Domicilio;
import edu.co.sena.akuavida.modelo.entitis.DomicilioPK;
import edu.co.sena.akuavida.modelo.entitis.Municipio;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.DepartamentoDAOImpl;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.DomicilioDAOImpl;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ColsutecR
 */
public class DomicilioDAOImplTest {
    
    Domicilio entity = new Domicilio();

    public DomicilioDAOImplTest() {
    }

       
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setMunicipioidMunicipio(new Municipio("2000"));
        entity.setDomicilioPK(new DomicilioPK("C.C", "1033790199"));
        entity.setCiudad("El Bronx");
        entity.setDireccion("Calle 49 G # 6 A 29 sur ");
        entity.setTelefono("3217915742");
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
    public void testInsert() {
        System.out.println("Insert");
        DomicilioDAOImpl instance = new DomicilioDAOImpl();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() {
        System.out.println("Update");
        entity.setTelefono("3125487264");
        DomicilioDAOImpl instance = new DomicilioDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() {
        System.out.println("delete");
        DomicilioDAOImpl instance = new DomicilioDAOImpl();
        Domicilio cct = instance.findByIDDomicilio(new DomicilioPK("C.C", "1033790199"));
        instance.delete(cct);
    }
    
    @Test
    public void testFindByIDDomicilio() {
        System.out.println("findByIDDomicilio");
        Departamento cct;
        String idDepartamento = "33";
        DepartamentoDAOImpl dep = new DepartamentoDAOImpl();
        cct = dep.findByIDDepartamento(idDepartamento);
        System.out.println(cct.toString());
    }
    
    @Test
    public void testFindbyAll() {
        System.out.println("findByAll");
        DepartamentoDAOImpl instance = new DepartamentoDAOImpl();
        List<Departamento> result = instance.findByAll();
        for (Departamento result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    
    @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        String nombre = "Johana";
        DepartamentoDAOImpl instance = new DepartamentoDAOImpl();
        List<Departamento> result = instance.findByNombre(nombre);
        for (Departamento result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
}
