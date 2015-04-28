/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.entities.test;

import edu.co.sena.akuavida.modelo.entitis.Departamento;
import edu.co.sena.akuavida.modelo.entitis.Municipio;
import edu.co.sena.akuavida.modelo.jpa.dao.implementacion.MunicipioDAOImpl;
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
public class MunicipioDAOImplTest {
    
    Municipio entity = new Municipio();

    public MunicipioDAOImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        entity.setIdMunicipio("20000");
        entity.setNombreMunicipio("Johana");
        entity.setDepartamentoidDepartamento(new Departamento("1"));
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
        MunicipioDAOImpl instance = new MunicipioDAOImpl();
        instance.insert(entity);
    }
    
    @Test
    public void testUpdate() {
        System.out.println("Update");
        entity.setNombreMunicipio("Maicol");
        MunicipioDAOImpl instance = new MunicipioDAOImpl();
        instance.update(entity);
    }
    
    @Test
    public void testDelete() {
        System.out.println("delete");
         MunicipioDAOImpl instance = new MunicipioDAOImpl();
        Municipio cct = instance.findByIDMunicipio("2000");
        instance.delete(cct);
    }
    
    @Test
    public void testFindByIdMunicipio() {
        System.out.println("findByIdMunicipio");
        Municipio cct;
        String idMunicipio= "2000";
        MunicipioDAOImpl mun = new MunicipioDAOImpl();
        cct = mun.findByIDMunicipio(idMunicipio);
        System.out.println(cct.getIdMunicipio());
    }
    
    @Test
    public void testFindByAll() {
        System.out.println("findByAll");
        MunicipioDAOImpl instance = new MunicipioDAOImpl();
        List<Municipio> result = instance.findByAll();
        for (Municipio result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
    
    @Test
    public void testFindByNombre() {
        System.out.println("findByNombre");
        String nombre = "Johana";
        MunicipioDAOImpl instance = new MunicipioDAOImpl();
        List<Municipio> result = instance.findByNombre(nombre);
        for (Municipio result1 : result) {
            System.out.println(result1.toString());
        }
    }
    
}
