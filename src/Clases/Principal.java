/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Interfaces.PantallaCarga;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author vittorio
 */
public class Principal {
    /**
     * @param args the command line arguments
     */
    private Socket ClE;
    private Socket ClR;
    
    
    public static void main(String[] args) {
        PantallaCarga.main(args);
        ConexionS Cl = new ConexionS();
        ClienteE CE = new ClienteE(Cl);
        ClienteR CR = new ClienteR(Cl);
        LoopC Lo = new LoopC(Cl);
        
        
        CE.start();
        CR.start();
        Lo.start();
        
        try {
            CE.join();
            CR.join();
            Lo.join();}catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);}
        
    }

    
    
    
    
    
}
