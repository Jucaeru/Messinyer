/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Cliente {
    public static void main(String[] args){
       try{ 
        
    Socket cliente = new Socket("localhost",8000);
        
    InputStream flujoEntrada = cliente.getInputStream();
    OutputStream flujoSalida = cliente.getOutputStream();
        
    BufferedReader entrada = new BufferedReader(new InputStreamReader (flujoEntrada));
    PrintWriter salida = new PrintWriter(flujoSalida,true);  
    
    BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
    String MensajeAEnviar = "";
    String mensajeRecibir = "";
    while(true){
        System.out.println("Enviar:");
        MensajeAEnviar = datosUsuario.readLine();
        salida.println(MensajeAEnviar);
        mensajeRecibir = entrada.readLine();
        System.out.println(mensajeRecibir);
    }
    //entrada.close();
    //salida.close();
    
       } catch (IOException ex) {
        
    }
       Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
}

    Cliente(Socket cliente) {
        this.cliente=cliente;
    }
