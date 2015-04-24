/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.interfaces;

import edu.co.sena.akuavida.modelo.entitis.Usuario;
import java.util.List;

/**
 *
 * @author maicolsteven
 */
public interface IUsuarioDAO {
    
     public void insert(Usuario entity);
    public void update(Usuario entity);
    public void delete(Usuario entity);

    public Usuario findByIDUsuario();

    public List<Usuario> findByAll();
    public List<Usuario> findByRol(Object rol);
    public List<Usuario> findByEstado(Object estado);
    public List<Usuario> findByContrasena(Object contrasena);
    public List<Usuario> findByCorreo(Object correo);
    
}
