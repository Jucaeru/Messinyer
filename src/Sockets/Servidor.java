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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try{ 
        //1. Establecer el servidor
        ServerSocket servidor = new ServerSocket(8000);
        System.out.println("Esperando conexiones");
        while (true){
            Socket cliente = servidor.accept();
            Cliente c = new Cliente(cliente);
            
        }
        System.out.println("Se conectó un cliente");
        
        InputStream flujoEntrada = cliente.getInputStream();
        OutputStream flujoSalida = cliente.getOutputStream();
        
        BufferedReader entrada = new BufferedReader(new InputStreamReader (flujoEntrada));
        BufferedReader datosUsuario = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter salida = new PrintWriter(flujoSalida,true);
        String mensaje = "";
        String mensajeEnviar = "";
        while(true){
            mensaje = entrada.readLine();
            System.out.println(mensaje);
            System.out.println("Enviar:");
            mensajeEnviar = datosUsuario.readLine();
            salida.println(mensajeEnviar);
        }
        //entrada.close();
        //salida.close();
    } catch (IOException ex) {
        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
