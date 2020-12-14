/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class Mil implements Runnable{
    
    private boolean option;
    
    public Mil(){
        option=true;
    }
    
    public void desactivar(){
        option=false;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(1000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
