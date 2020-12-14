/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author alumno
 */
public class main {
    public boolean option;
    public static void main(String[] args) {
        Hola s=new Hola();
        Mil m=new Mil();
        Oracion f=new Oracion();
        
        Thread hilo1=new Thread(s);
        Thread hilo2=new Thread(m);
        Thread hilo3=new Thread(f);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();        
    }
}
