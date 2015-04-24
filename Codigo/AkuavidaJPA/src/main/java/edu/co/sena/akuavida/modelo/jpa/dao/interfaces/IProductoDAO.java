/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Producto;
import java.util.List;

/**
 *
 * @author Tatiana
 */
public interface IProductoDAO {
    public void insert(Producto entity);
    public void update(Producto entity);
      public void delete(Producto entity);
    
       public Producto findByIDproducto(String idProducto);  
    
      public List<Producto> findByAll();
      public List<Producto> findByNombre(String nombre);
      public List<Producto> findByPrecio(float precio);
      public List<Producto> findByCantidad(int cantidad);
      public List<Producto> findByActivo(boolean activo);
      public List<Producto> findByImpuesto(float impuesto);
    
}
