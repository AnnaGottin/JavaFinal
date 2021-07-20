/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vittorio
 */
public class Cliente extends Thread{
    
    protected String IP = "127.0.0.1";
    protected int Puerto = 52888;
    protected Socket Cl;
    
    
    
    
    
    public void Iniciar(){
        try {
            this.Cl = new Socket(IP,Puerto);
            PrintWriter Out = new PrintWriter(Cl.getOutputStream(),true);
            Out.println("Exito");
//            DataOutputStream Out = new DataOutputStream(Cl.getOutputStream());
//            Out.writeUTF("EXito");
            Out.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString() , "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void run(){
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
    
    public void Ex(){
        try {
            this.Cl.close();
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
    
    
    
//    protected Socket cliente;
//    protected int puerto=54200;
//    protected String ip="127.0.0.1"; //Servidor local “localhost”
//    protected DataOutputStream output;
//    protected DataInputStream input;
//    public void iniciar(){
//        Scanner teclado=new Scanner(System.in);
//        try{
//            //conexión con el servidor mediante ip y puerto
//            cliente = new Socket(ip,puerto);
//            output = new DataOutputStream(cliente.getOutputStream());
//            input = new DataInputStream(cliente.getInputStream());
//            String mnsS="";
//            String mnsE="";
//            while(!mnsS.equals("exit")){
//                //mantiene la comunicación hasta recibir “exit”
//                mnsS=teclado.nextLine();
//                output.writeUTF(mnsS);
//                mnsE=input.readUTF();
//                System.out.println("Servidor dice: "+mnsE);
//            }
//            output.close();
//            input.close();
//            cliente.close();
//        }catch(Exception ex){}
//    }
    public static void main(String[] args) {
        Cliente Nodo = new Cliente();
        Nodo.start();
    }
}
