/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.dao.test;

import edu.co.sena.akuavida.modelo.jpa.entities.test.*;
import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.DepartamentoDAOImpl;
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
public class DepartamentoDAOImplTest {
    
    Departamento entity = new Departamento();

    public DepartamentoDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setIdDepartamento("33");
        entity.setNombreDepartamento("Johana");
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
        DepartamentoDAOImpl instance = new DepartamentoDAOImpl();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() {
        System.out.println("Update");
        entity.setNombreDepartamento("Maicol");
        DepartamentoDAOImpl instance = new DepartamentoDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() {
        System.out.println("delete");
        DepartamentoDAOImpl instance = new DepartamentoDAOImpl();
        Departamento cct = instance.findByIDDepartamento("33");
        instance.delete(cct);
    }
    
    @Test
    public void testFindByIdDepartamento() {
        System.out.println("findByIdDepartamento");
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
