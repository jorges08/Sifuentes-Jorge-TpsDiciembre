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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Juan Manuel
 */
public class Amarillo extends Thread{
    
    
    protected boolean cicloVida = true;
    protected JLabel estadoAmarillo;
    private Rojo hiloRojo;
    Image amarillo = new ImageIcon(getClass().getResource("imagenes/amarillo.png")).getImage();
    ImageIcon amarilloIcon = new ImageIcon(amarillo.getScaledInstance(50, 100, Image.SCALE_SMOOTH));
    
    public Amarillo( JLabel a , Rojo hRojo )
    {
        this.estadoAmarillo = a;
        this.hiloRojo = hRojo;
    }
    
    
    @Override
    public void run()
    {
        try {
        
            while( cicloVida )
            {
                hiloRojo.join();
                estadoAmarillo.setIcon(amarilloIcon);
                Thread.sleep( 1000 );
                cicloVida = false;     
            }
            
            
        } catch (InterruptedException ex) {
                Logger.getLogger(Amarillo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
