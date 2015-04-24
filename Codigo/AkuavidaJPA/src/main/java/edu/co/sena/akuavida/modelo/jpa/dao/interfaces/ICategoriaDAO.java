/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Categorias;
import java.util.List;



/**
 *
 * @author Tatiana
 */
public interface ICategoriaDAO {
    public void insert(Categorias entity);
    public void update(Categorias entity);
    public void delete(Categorias entity);
    
    
     public Categorias findByIDCategoria(int idCategoria);  
    
     public List<Categorias> findByAll();
      public List<Categorias> findByNombre(String nombre);
      public List<Categorias> findByActiva(boolean activa);
      public List<Categorias> findByPariente(int pariente);
     
    
}
