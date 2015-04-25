/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarrito;
import edu.co.sena.akuavida.modelo.entitis.ItemsDelCarritoPK;
import java.util.List;

/**
 *
 * @author Tatiana
 */
public interface IItemCarritoDeComprasDAO  {
    public void insert(ItemsDelCarrito entity);
    public void update(ItemsDelCarrito entity);
    public void delete(ItemsDelCarrito entity);
    
    public ItemsDelCarrito findByIDItemDeCarrito(ItemsDelCarritoPK itemsDelCarritoPK); 
    
    public List<ItemsDelCarrito> findByAll();
           
      public List<ItemsDelCarrito> findByCantidad(int cantidad);
      public List<ItemsDelCarrito> findByCostoUnitario(float costoUnitario);
      public List<ItemsDelCarrito> findByCostoTotal(float costoTotal);
      
    
}
