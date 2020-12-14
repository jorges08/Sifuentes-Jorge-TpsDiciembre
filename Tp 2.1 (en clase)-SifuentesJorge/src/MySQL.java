/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Dani
 */
public class MySQL {
    
    protected Connection conn;
    public String DB;
    PreparedStatement Ps = null; //GENERAR CONSULTAS
    static PrintStream ps=new PrintStream(System.out);
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    
    
    public MySQL(String user, String pass, String ruta, String database){
        
        this.DB = database;
        
        try {
            Class.forName("con.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String url = "jdbc:mysql://"+ ruta +":3306/"+ database +"?zeroDateTimeBehavior=CONVERT_TO_NULL";
        try {
            
            conn = DriverManager.getConnection( url , user , pass);
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void Insertar( String tabla, ArrayList<String> campos, ArrayList<Object> datos  ) throws SQLException{        
        
        String consulta = "INSERT INTO"+ tabla + "(";        
        for( String dato : campos){
            
            consulta = consulta + dato + ", ";
            
        }
        
        consulta = consulta.substring(0, consulta.length()+2) +") VALUES (";
        
        for( Object valores : datos){
            
            consulta = consulta + valores + ", ";
            
        }
        
        consulta = consulta.substring(0, consulta.length()+2) + " )";
        
        PreparedStatement Ps = conn.prepareStatement(consulta);
        

        if( Ps.executeUpdate() == -1 ){
            ps.println("Error con insertar.....");
        }
        
        
        
        Ps.close();
    }
    
    public ResultSet verificar() throws IOException, SQLException{
        ResultSet Rs = null;
        int i = 1;
        while( i == 1){
            ps.println("Primero debemos verificar su cuenta");
            ps.println("Ingrese su usuario");
            String nom=br.readLine();
            ps.println("Ingrese su contraseña");
            String pas=br.readLine();

            Ps = conn.prepareStatement("SELECT * FROM 'usuarios' WHERE nombre ='"+nom+"' AND pass= '"+pas+"' ");

            while( Ps.executeUpdate() != -1){
                ps.println("El usuario es correcto");
                i = i+1;
                return Rs;
            }
        }
        return null;
    }
  
    public void MostrarNota( String tabla ) throws SQLException {

        PreparedStatement Ps = conn.prepareStatement ("SELECT * FROM" + tabla + "GROUP BY docenteId ORDER BY materia");
        ResultSet Rs = Ps.executeQuery();
        
        while( Rs.next() ){
            
            ps.println( " Materia: " + Rs.getString + ("materia") +
                        " Usuario: " + Rs.getString + ("usuario") +
                        " Nota: "    + Rs.getFloat  + ("nota") 
                      );
        }
        
        
        }
        
    public void Desconectar(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void Cambiar() throws IOException, SQLException{
        
        ResultSet Rs = this.verificar();
        ResultSet nombre = this.verificar();
        
        
        if( Rs.next() ){
            
            ps.println("Ingrese su nueva contraseña: ");
            String password = br.readLine();
            
            conn.prepareStatement("UPDATE usuarios SET pass='"+password+"'WHERE nombre='"+nombre+"'");
            
            if( Ps.executeUpdate() == -1 ){
                
                ps.println(" No se cambio la contraseña ");
            }
     
        }
        Ps.close();
        conn.close();
    }

}
