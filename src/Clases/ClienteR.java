/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;




/**
 *
 * @author vittorio
 */
public class ClienteR extends Thread{
    protected ConexionS Cl;
    public ClienteR(ConexionS Cl) {
        this.Cl = Cl;
    }
    
    @Override
    public void run(){
        
    }
    
}
