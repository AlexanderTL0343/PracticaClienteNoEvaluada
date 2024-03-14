/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redesswing;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author alext
 */
public class Server {
     private ServerSocket server;
    private boolean isRunning;
    private LinkedList<Socket> clients;
    
    /**
     * 
     * @throws IOException 
     */
    public Server() throws IOException {
        this.server = new ServerSocket(6060);
        this.isRunning = false;
        this.clients = new LinkedList<Socket>();
    }
    
    /**
     * 
     */
    public void runServer() {
        this.isRunning = true;
        while(this.isRunning) {
            Socket client = null;
            
            // Accepting a new client
            try {
                client = this.server.accept();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Creating data output stream to send data to the client
            DataOutputStream dos = null;
            DataInputStream dis = null;

            try {
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (dos != null) {
                try {
                    dos.writeUTF("Hi Im your father");
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            try {
                dis = new DataInputStream(client.getInputStream());
                
                System.out.println("Message received from client: " + dis.readUTF());
                dos.close();
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if (client != null) {
                // Closing the client
                try {
                    client.close();
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }
    
}
