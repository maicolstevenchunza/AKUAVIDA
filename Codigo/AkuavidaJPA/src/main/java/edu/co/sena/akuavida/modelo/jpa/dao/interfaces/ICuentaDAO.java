/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;


import edu.co.sena.akuavida.modelo.entitis.Cuenta;
import edu.co.sena.akuavida.modelo.entitis.CuentaPK;
import java.util.List;

/**
 *
 * @author toshiba_
 */
public interface ICuentaDAO {
    public void insert(Cuenta entity);
    public void update(Cuenta entity);
    public void delete(Cuenta entity);
    
    public Cuenta finByCuentaPk(CuentaPK cuentaPKLlaves);
    
    public List<Cuenta> findByAll();
    public List<Cuenta> findByPrimerNombre(String primerNombre);   
    public List<Cuenta> findBySegundoNombre(String segundoNombre);   
    public List<Cuenta> findByPrimerApellido(String primerApellido);   
    public List<Cuenta> findBySegundoApellido(String segundoApellido);    
    public List<Cuenta> findByDireccion(String direccion);   
    public List<Cuenta> findByTelefono(String telefono);   
    public List<Cuenta> findByRool(String rool);   
    public List<Cuenta> findByActivo(boolean activo);   
   
}
