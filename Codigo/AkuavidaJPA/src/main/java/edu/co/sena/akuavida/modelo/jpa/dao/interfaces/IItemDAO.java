/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Item;
import java.util.List;

/**
 *
 * @author toshiba_
 */
public interface IItemDAO {
    public void insert(Item entity);
    public void update(Item entity);
    public void delete(Item entity);
    
    public Item findByAll();
    
    public List<Item> findByCantidad (Object cantidad);
    public List<Item> findByCostoTotal (Object costoTotal);
    public List<Item> findByCostoUnitario(Object costoUnitario);  
}
