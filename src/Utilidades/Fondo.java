/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Führer
 */
public class Fondo extends javax.swing.JPanel {


    private ImageIcon imageIcon = new ImageIcon("/Utilidades/fondo.png");  
  
    public Fondo(JFrame frame) {  
        //setPreferredSize(new Dimension(601, 279));
        setOpaque(false);  
    }  
  
    //el truco para establecer la imagen de fondo es sobreescribir el metodo paint()  
    @Override  
    public void paint(Graphics g) {  
        final BufferedImage image;
        try {
            image = ImageIO.read(new File(getClass().getResource("/Utilidades/fondo.png").toURI()));
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);  
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(Fondo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        super.paint(g);  
    }  
}
