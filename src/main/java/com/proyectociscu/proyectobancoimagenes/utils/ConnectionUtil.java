package com.proyectociscu.proyectobancoimagenes.utils;

import com.proyectociscu.proyectobancoimagenes.model.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionUtil {
    private static java.sql.Connection _conn = null;
    
    public static java.sql.Connection connect(Connection c) throws ClassNotFoundException, SQLException{
        java.sql.Connection conn = null;
        
        if(c==null){
            conn = null;
        }else{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://"+c.getHost()+"/"+c.getDb()+
                    "?useLegacyDatetimeCode=false&serverTimezone=UTC",c.getUser(),c.getPassword());
        }
        
        return conn; 
    }
    
    public static java.sql.Connection getConnection(){
        if(_conn == null){
            Connection c = new Connection();
            c.loadDataXML();
            try {
                _conn=connect(c);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println("Falta la base de datos");
                System.exit(0);
                Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _conn;
    }
    
    //cerrar conexion <- falta
}
