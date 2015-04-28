/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Promociones;
import java.util.List;

/**
 *
 * @author Andrea
 */
public interface IPromocionesDAO {

    public void insert(Promociones entity);
    public void update(Promociones entity);
    public void delete(Promociones entity);
    
    public Promociones findByIDPromocion(int idPromocion);
    public List<Promociones> findByAll();
    public List<Promociones> findByDescuentos(Object descuentos);
    public List<Promociones> findByNombre(Object nombre);
    public List<Promociones> findByPrecio(Object precio);


}
