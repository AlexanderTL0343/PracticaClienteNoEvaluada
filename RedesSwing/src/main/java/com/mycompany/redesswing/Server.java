/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redesswing;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author alext
 */
public class Server extends Thread{
    
    Socket s;
    Perfiles Archivo = new Perfiles();

    public Server(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        Archivo.Inicio();

        DataInputStream dis = null;
        DataOutputStream dos = null;

        try {
            
            dis = new DataInputStream(s.getInputStream());
            Archivo.Revision(dis.readUTF());

         
            dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(Archivo.getRespuesta());

          
            dis.close();
            dos.close();

        } catch (IOException e) {
        }

        if (s != null) {
            //closing the client
            try {
                s.close();
            } catch (IOException e) {

            }
        }

    }
}
