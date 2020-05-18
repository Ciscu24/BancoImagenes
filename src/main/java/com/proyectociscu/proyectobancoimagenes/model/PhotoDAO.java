package com.proyectociscu.proyectobancoimagenes.model;

import com.proyectociscu.proyectobancoimagenes.model.Photo;
import com.proyectociscu.proyectobancoimagenes.utils.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhotoDAO extends Photo implements IPhotoDAO{

    private boolean persist;

    public PhotoDAO() {
        super();
        persist = false;
    }
    
    public PhotoDAO(int codigo, String titulo, String categoria, String descripcion, String ruta, int codcliente){
        super(codigo, titulo, categoria, descripcion, ruta, codcliente);
        persist = false;
    }
    
    public PhotoDAO(String titulo, String categoria, String descripcion, String ruta, int codcliente){
        super(-1, titulo, categoria, descripcion, ruta, codcliente);
        persist = false;
    }
    
    public PhotoDAO(Photo p){
        codigo = p.codigo;
        titulo = p.titulo;
        categoria = p.categoria;
        descripcion = p.descripcion;
        ruta = p.ruta;
        codcliente = p.codcliente;
    }
    
    public void persist(){
        persist = true;
    }
    
    public void detatch(){
        persist = false;
    }

    @Override
    public void setCodigo(int codigo) {
        super.setCodigo(codigo);
        if(persist){
            save();
        }
    }

    @Override
    public void setRuta(String ruta) {
        super.setRuta(ruta);
        if(persist){
            save();
        }
    }

    @Override
    public void setCodcliente(int codcliente) {
        super.setCodcliente(codcliente);
        if(persist){
            save();
        }
    }

    @Override
    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
        if(persist){
            save();
        }
    }

    @Override
    public void setCategoria(String categoria) {
        super.setCategoria(categoria);
        if(persist){
            save();
        }
    }

    @Override
    public void setTitulo(String titulo) {
        super.setTitulo(titulo);
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
                String q = "UPDATE imagenes SET titulo = ?, categoria = ?, descripcion = ?, ruta = ?, codcliente = ? WHERE codigo = ?";
                PreparedStatement ps = csql.prepareStatement(q);
                ps.setString(1, titulo);
                ps.setString(2, categoria);
                ps.setString(3, descripcion);
                ps.setString(4, ruta);
                ps.setInt(5, codcliente);
                ps.setInt(6, codigo);
                result= ps.executeUpdate();
            }else{
                //INSERT
                String q = "INSERT INTO imagenes (codigo,titulo,categoria,descripcion,ruta,codcliente) VALUES(NULL,?,?,?,?,?)";
                PreparedStatement ps = csql.prepareStatement(q, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, titulo);
                ps.setString(2, categoria);
                ps.setString(3, descripcion);
                ps.setString(4, ruta);
                ps.setInt(5, codcliente);
                result = ps.executeUpdate();
                try(ResultSet generatedKeys = ps.getGeneratedKeys()){
                    if(generatedKeys.next()){
                        result = generatedKeys.getInt(1); //<-- return last id inserted
                    }
                }
                this.codigo = result;
            }
            
        }catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    public static List<Photo> selectAll(){
        return selectAll("");
    }
    
    public static List<Photo> selectAll(String pattern){
        List<Photo> result = new ArrayList<>();
        
        try {
            java.sql.Connection csql = ConnectionUtil.getConnection();
            String q = "SELECT * FROM imagenes";
            
            if(pattern.length()>0){
                q+=" WHERE nombre LIKE ?";
            }
            
            PreparedStatement ps = csql.prepareStatement(q);
            
            if(pattern.length()>0){
                ps.setString(1, pattern+"%");
            }
            
            ResultSet rs = ps.executeQuery();
            
            if(rs != null){
                while(rs.next()){
                    Photo n = new Photo();
                    n.setCodigo(rs.getInt("codigo"));
                    n.setTitulo(rs.getString("titulo"));
                    n.setCategoria(rs.getString("categoria"));
                    n.setDescripcion(rs.getString("descripcion"));
                    n.setRuta(rs.getString("ruta"));
                    n.setCodcliente(rs.getInt("codcliente"));
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
                String q = "DELETE FROM imagenes WHERE codigo = " + this.codigo;
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
