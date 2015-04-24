/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;


import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import java.util.List;

/**
 *
 * @author toshiba_
 */
public interface ICuentaDAO {
    public void insert(Cuenta entity);
    public void update(Cuenta entity);
    public void delete(Cuenta entity);
    
    public List<Cuenta> findByAll();   
    public List<Cuenta> findByPrimerNombre(Object primerNombre);   
    public List<Cuenta> findBySegundoNombre(Object segundoNombre);   
    public List<Cuenta> findByPrimerApellido(Object primerApellido);   
    public List<Cuenta> findBySegundoApellido(Object segundoApellido);    
    public List<Cuenta> findByDireccion(Object direccion);   
    public List<Cuenta> findByTelefono(Object telefono);   
    public List<Cuenta> findByRool(Object rool);   
    public List<Cuenta> findByActivo(Object activo);   
   
}
