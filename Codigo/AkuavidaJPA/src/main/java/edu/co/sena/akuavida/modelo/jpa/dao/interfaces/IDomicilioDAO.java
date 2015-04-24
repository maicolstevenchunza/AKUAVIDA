/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Domicilio;
import java.util.List;

/**
 *
 * @author maicolsteven
 */
public interface IDomicilioDAO {
    
     public void insert(Domicilio entity);
    public void update(Domicilio entity);
    public void delete(Domicilio entity);

    public Domicilio findByIDDomicilio();

    public List<Domicilio> findByAll();
    public List<Domicilio> findByCiudad(Object ciudad);
    public List<Domicilio> findByDireccion(Object direccion);
    public List<Domicilio> findByTelefono(Object telefono);
}
