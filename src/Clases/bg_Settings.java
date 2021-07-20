/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author vittorio
 */
public class bg_Settings implements Icon {
    String[] Backgrounds =  {"bg_0001.jpg","bg_0002.jpg","bg_0003.jpg","bg_0004.png","bg_0005.png","bg_0006.png",
    "bg_0007.jpg","bg_0008.jpg","bg_0009.jpg","bg_0010.jpg","bg_0011.jpg"};
    //Nombre de los fondos a ser usados, estan en la carpeta LoadScreen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //Obtiene las dimensiones de la pantalla en mi caso me da un aproximado muy cercano
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Random Rand = new Random();
        //La idea es que nos de un "Id" aleatorio del array compuesto por el nombre de las imagenes
        int Num = Rand.nextInt(Backgrounds.length - 1);
        //Pide un numero aleatorio
        
        Image image = new ImageIcon(getClass().getResource("/LoadScreen/"+Backgrounds[Num])).getImage();
        //Se carga
        //Cambia screenSize.width para el ancho que quieres que tenga la imagen
        //Cambia screenSize.heigh para el alto que quieres que tenga la imagen
        //Si te sientes atrevido podrias tener esta clase recibiendo en su constructor esos tamaños y ver como lleguen aqui
        g.drawImage(image, x, y, screenSize.width, screenSize.height, c);
        //se cambia el tamaño de la misma
    }

    @Override
    public int getIconWidth() {
        return screenSize.width;
    }

    @Override
    public int getIconHeight() {
        return screenSize.height;
    }
}
