package com.proyectociscu.proyectobancoimagenes.model;

import com.proyectociscu.proyectobancoimagenes.model.Client;
import com.proyectociscu.proyectobancoimagenes.utils.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDAO extends Client implements IClientDAO{

    private boolean persist;

    public ClientDAO() {
        super();
        persist = false;
    }
    
    public ClientDAO(int codigo, String nombre, String apellidos, String usuario, String contrasena){
        super(codigo, nombre, apellidos, usuario, contrasena);
        persist = false;
    }
    
    public ClientDAO(String nombre, String apellidos, String usuario, String contrasena){
        super(-1, nombre, apellidos, usuario, contrasena);
        persist = false;
    }
    
    public ClientDAO(Client c){
        codigo = c.codigo;
        nombre = c.nombre;
        apellidos = c.apellidos;
        usuario = c.usuario;
        contrasena = c.contrasena;
    }
    
    public void persist(){
        persist = true;
    }
    
    public void detatch(){
        persist = false;
    }
    
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
        if(persist){
            save();
        }
    }

    @Override
    public void setContrasena(String contrasena) {
        super.setContrasena(contrasena);
        if(persist){
            save();
        }
    }

    @Override
    public void setUsuario(String usuario) {
        super.setUsuario(usuario);
        if(persist){
            save();
        }
    }

    @Override
    public void setApellidos(String apellidos) {
        super.setApellidos(apellidos);
        if(persist){
            save();
        }
    }

    @Override
    public void setCodigo(int codigo) {
        super.setCodigo(codigo);
        if(persist){
            save();
        }
    }
    
    @Override
    public int save(){
        int result = -1;
        
        try {
            java.sql.Connection csql = ConnectionUtil.getConnection();
            
            if(this.codigo>0){
                //UPDATE
                String q = "UPDATE clientes SET nombre = ?, apellidos = ?, usuario = ?, contrasena = ? WHERE codigo = ?";
                PreparedStatement ps = csql.prepareStatement(q);
                ps.setString(1, nombre);
                ps.setString(2, apellidos);
                ps.setString(3, usuario);
                ps.setString(4, contrasena);
                ps.setInt(5, codigo);
                result= ps.executeUpdate();
            }else{
                //INSERT
                String q = "INSERT INTO clientes (codigo,nombre,apellidos,usuario,contrasena) VALUES(NULL,?,?,?,?)";
                PreparedStatement ps = csql.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, nombre);
                ps.setString(2, apellidos);
                ps.setString(3, usuario);
                ps.setString(4, contrasena);
                result = ps.executeUpdate();
                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        result = generatedKeys.getInt(1); //devuelve el ultimo id insertado
                    }
                }
                this.codigo = result;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public static List<Client> selectAll(){
        return selectAll("");
    }
    
    /**
     * Funcion que selecciona por usuario todos los clientes de la base de datos que sea por el pattern
     * @param pattern Palabra por lo que se filtra el select
     * @return devuelve una lista de clientes
     */
    public static List<Client> selectAll(String pattern){
        List<Client> result = new ArrayList<>();
        
        try {
            java.sql.Connection csql = ConnectionUtil.getConnection();
            String q = "SELECT * FROM clientes";
            
            if(pattern.length()>0){
                q+=" WHERE usuario LIKE ?";
            }
            
            PreparedStatement ps = csql.prepareStatement(q);
            
            if(pattern.length()>0){
                ps.setString(1, pattern+"%");
            }
            
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Client n = new Client();
                    n.setCodigo(rs.getInt("codigo"));
                    n.setNombre(rs.getString("nombre"));
                    n.setApellidos(rs.getString("apellidos"));
                    n.setUsuario(rs.getString("usuario"));
                    n.setContrasena(rs.getString("contrasena"));
                    result.add(n);
                }
            }
        }catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    @Override
    public int remove(){
        int result = -1;
        
        if(this.codigo > 0){
            
            try{
                java.sql.Connection csql = ConnectionUtil.getConnection();
                String q = "DELETE FROM clientes WHERE codigo = " + this.codigo;
                PreparedStatement ps = csql.prepareStatement(q);
                result = ps.executeUpdate();
                if(result>0)
                    this.codigo=-1;
            }catch (SQLException ex) {
                Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return result;
    }
    
}
