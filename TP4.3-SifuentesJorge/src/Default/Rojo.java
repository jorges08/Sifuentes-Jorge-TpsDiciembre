/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Juan Manuel
 */
public class Rojo extends Thread{
    
    
    protected boolean cicloVida = true;
    protected JLabel estadoRojo;
    Image rojo = new ImageIcon(getClass().getResource("imagenes/rojo.png")).getImage();
    ImageIcon rojoIcon = new ImageIcon(rojo.getScaledInstance(50, 100, Image.SCALE_SMOOTH));
    
    public Rojo( JLabel r )
    {
        this.estadoRojo = r;
        
    }
    
    
    @Override
    public void run()
    {
        try {
        
            while( cicloVida )
            {

                estadoRojo.setIcon(rojoIcon);
                Thread.sleep( 2000 );
                cicloVida = false;

            }
            
            
        } catch (InterruptedException ex) {
                Logger.getLogger(Rojo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
