import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dani
 */
public class base {
    
    static String user = "root";
    static String pass = "";
    static String ruta = "localhost";
    static String database = "evaluaciones_online";
    
    PreparedStatement Ps = null; //GENERAR CONSULTAS
    static PrintStream ps=new PrintStream(System.out);
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws IOException, SQLException {
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/evaluaciones_online?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "");

            
            
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            Logger.getLogger(base.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        PrintStream ps = new PrintStream (System.out);
        
        int opcion = 3;        
        while(opcion <= 4 && opcion >= 1){
        
        ps.println("--->Menu<---");
        ps.println("Eliga la opcion ingresando la letra correspondiente.");
        ps.println("|* Agregar               -  1 *|");
        ps.println("|* Inscribir Examen      -  2 *|");
        ps.println("|* Mostrar Notas         -  3 *|");
        ps.println("|* Cambiar Contraseña    -  4 *|");
        ps.println("|* Salir                 -  5 *|");

        
        opcion = Integer.parseInt(br.readLine());

            switch(opcion){
        
                 case 1 -> agregar();
                 case 2 -> inscribir();
                 case 3 -> mostrarNotas();
                 case 4 -> cambiarContraseña();
                 default -> {
                     System.out.println("La opcion no existe.");
                     System.out.println("Solo del 1 al 5.");
                }
            }     
        }      
    }
    
    
    

    private static void agregar() throws IOException {
        

        MySQL sql = new MySQL(user, pass, ruta, database);
        ArrayList<String> columnas = new ArrayList<>();
        ArrayList<Object> datos = new ArrayList<>();
        
        datos.add(56);
        datos.add("fff");
        
        try {
            
            sql.Insertar("usuarios", columnas, datos);
            
        } catch (SQLException ex) {
            Logger.getLogger(base.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        columnas.clear();
        datos.clear();
        sql.Desconectar();
        
    }
      

    private static void inscribir() throws IOException, SQLException{
        MySQL sql = new MySQL(user, pass, ruta, database);

        sql.verificar();
        sql.Desconectar();
    }

    private static void mostrarNotas() {
   
        MySQL sql = new MySQL(user, pass, ruta, database);
        
        try {
            sql.MostrarNota( "examenes" );
        } catch (SQLException ex) {
            Logger.getLogger(base.class.getName()).log(Level.SEVERE, null, ex);
        }
        sql.Desconectar();


    }

    private static void cambiarContraseña() throws IOException, SQLException {
        
        MySQL sql = new MySQL(user, pass, ruta, database);
        
        sql.verificar();
        
        sql.Cambiar();
        
        sql.Desconectar();

    }
}
