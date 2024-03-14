/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redesswingcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alext
 */
public class Client {
    private String ip;
    private int port;
    
    
    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
    
    public void runClient() {
        Socket client = null;
        try {
            client = new Socket(this.ip, this.port);
            
            // Receiving message from server
            DataInputStream dis = new DataInputStream(client.getInputStream());
            System.out.println("Message received from server: " + dis.readUTF());
            
            // Sending message to server
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            dos.writeUTF("Noooooooo");
            dis.close();
            dos.close();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (client != null) {
            try {
                client.close();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
    

