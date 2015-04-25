package edu.co.sena.akuavida.modelo.entitis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.co.sena.akuavida.modelo.entitis.Categorias;
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

/**
 *
 * @author toshiba_
 */
public class CategoriaTestJPA {

    Categorias categoria;

    EntityManagerFactory emf;
    EntityManager em;

    public CategoriaTestJPA() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        categoria = new Categorias();
        categoria.setIDCategoria(1);
        categoria.setNombre("Purificadores Prueba");
        categoria.setPariente(1);
        categoria.setActiva(true);

//        emf = Persistence.createEntityManagerFactory("edu.co.sena_TareaClasesJPA_jar_1.0-SNAPSHOTPU");
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
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
    public void insertarCategorias() {
        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.persist(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();
    }

    @Test
    public void actualizarCategoria() {

        String idCat = JOptionPane.showInputDialog("Escriba el id de la categoria");
        String actNom = JOptionPane.showInputDialog("Escriba el Nombre");

        categoria.setIDCategoria(Integer.parseInt(idCat));
        categoria.setNombre(actNom);

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        em.merge(categoria);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarUnaCategoria() {
        String idCategoria = JOptionPane.showInputDialog("Insertar El Id De La Categoria");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Categorias ct = em.find(Categorias.class, Integer.parseInt(idCategoria));

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

        System.out.println(ct.toString());
    }

    @Test
    public void borrarUnaCategoria() {
        String idCategoria = JOptionPane.showInputDialog("Escriba el id de la categoria a eliminar");
        try {
            em = EntityManagerHelper.getEntityManager();
            EntityManagerHelper.beginTransaction();

            em.remove(em.find(Categorias.class, Integer.parseInt(idCategoria)));
            EntityManagerHelper.commit();
            EntityManagerHelper.closeEntityManager();
            EntityManagerHelper.closeEntityManagerFactory();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar la categoria" + e.getMessage());
        }

    }

    @Test
    public void buscarCategorias() {

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();
        Query q = em.createNamedQuery("Categorias.findAll");
        List<Categorias> lis = q.getResultList();
        for (Categorias categoriaT : lis) {
            System.out.println(categoriaT.getIDCategoria() + " / " + categoriaT.getNombre() + " / " + categoriaT.getActiva() + " / " + categoriaT.getPariente());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorNombre() {
        String nombre = JOptionPane.showInputDialog("Insertar El nombre De La Categoria");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Categorias.findByNombre");
        query.setParameter("nombre", nombre);

        List<Categorias> lista = query.getResultList();
        for (Categorias categoriaT : lista) {
            System.out.println("ID Categoria: " + categoriaT.getIDCategoria() + " Nombre: " + categoriaT.getNombre() + " Activa: " + categoriaT.getActiva() + " Pariente " + categoriaT.getPariente());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorActiva() {

        String activa = JOptionPane.showInputDialog("Insertar si esta activa la categoria o no");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Categorias.findByActiva");
        query.setParameter("activa", Boolean.parseBoolean(activa));

        List<Categorias> lista = query.getResultList();
        for (Categorias categoriaT : lista) {
            System.out.println("ID Categoria: " + categoriaT.getIDCategoria() + " Nombre: " + categoriaT.getNombre() + " Activa: " + categoriaT.getActiva() + " Pariente " + categoriaT.getPariente());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

    @Test
    public void buscarPorPariente() {
        String pariente = JOptionPane.showInputDialog("Insertar el pariente de la categoria");

        em = EntityManagerHelper.getEntityManager();
        EntityManagerHelper.beginTransaction();

        Query query = em.createNamedQuery("Categorias.findByPariente");
        query.setParameter("pariente", Integer.parseInt(pariente));

        List<Categorias> lista = query.getResultList();
        for (Categorias categoriaT : lista) {
            System.out.println("ID Categoria: " + categoriaT.getIDCategoria() + " Nombre: " + categoriaT.getNombre() + " Activa: " + categoriaT.getActiva() + " Pariente " + categoriaT.getPariente());
        }

        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
        EntityManagerHelper.closeEntityManagerFactory();

    }

}
