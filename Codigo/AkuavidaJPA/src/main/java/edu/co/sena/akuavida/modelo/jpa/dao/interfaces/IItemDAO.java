/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Item;
import edu.co.sena.akuavida.modelo.entitis.ItemPK;
import java.util.List;

/**
 *
 * @author toshiba_
 */
public interface IItemDAO {
    public void insert(Item entity);
    public void update(Item entity);
    public void delete(Item entity);
    
    public Item findByIDItem(ItemPK itemsPK); 
    
    public List<Item> findByAll();
    public List<Item> findByCantidad (int cantidad);
    public List<Item> findByCostoTotal (float costoTotal);
    public List<Item> findByCostoUnitario(float costoUnitario);  
}
