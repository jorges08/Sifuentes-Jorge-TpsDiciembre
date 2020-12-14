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
public class Verde extends Thread{
    
    protected boolean cicloVida = true;
    private tpmulti reloj;
    private JLabel vent;
    private Amarillo hiloAmarillo;
    private Rojo hiloRojo;
    private tpmulti iniciar;
    Image verde = new ImageIcon(getClass().getResource("imagenes/verde.png")).getImage();
    ImageIcon verdeIcon = new ImageIcon(verde.getScaledInstance(50, 100, Image.SCALE_SMOOTH));
    public Verde( JLabel v , Amarillo a , Rojo r , tpmulti ventana)
    {
        this.vent = v;
        this.hiloAmarillo = a;
        this.hiloRojo = r;
        this.iniciar=ventana;
    }
    
    
    @Override
    public void run()
    {
        try {
        
            while(cicloVida)
            {
                hiloAmarillo.join();
                vent.setIcon(verdeIcon);
                Thread.sleep( 2000 );
                cicloVida = false;
                
                if( iniciar.apagar)
                    iniciar.intanciar();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(Verde.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
