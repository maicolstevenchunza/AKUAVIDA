/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.akuavida.modelo.jpa.dao.implementacion;

import edu.co.sena.akuavida.general.logger.util.Log4JConfiguration;
import org.apache.log4j.PropertyConfigurator;

/**
 *
 * @author ColsutecR
 */
public class AbstractDAO {

    public AbstractDAO() {
        PropertyConfigurator.configure(Log4JConfiguration.PROPERTIES); 
    }
    
    
}
