/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author vittorio
 */
public class ConexionS {
    
    protected String IP = "127.0.0.1";
    protected int Puerto = 52888;
    protected Socket Cl;
    
    public int Test(){
        try {
            Socket T = new Socket(IP,Puerto);
            PrintWriter Out = new PrintWriter(T.getOutputStream(),true);
            Out.println("Prueba");
            T.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Servidor no Disponible", "Error", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }
    
    public void Iniciar(){
        try {
            this.Cl = new Socket(IP,Puerto);
            PrintWriter Out = new PrintWriter(Cl.getOutputStream(),true);
            Out.println("Exito");
//            DataOutputStream Out = new DataOutputStream(Cl.getOutputStream());
//            Out.writeUTF("EXito");
//            Out.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void Loop(){
        int B;
        do{            
            B = Test();
            if(B == 1 && Cl == null)
                Iniciar();
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {            }
        }while (Cl != null);
    }
    
    
}
