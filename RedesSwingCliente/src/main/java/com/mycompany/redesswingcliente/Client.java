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
import javax.imageio.IIOException;
/**
 *
 * @author alext
 */
public class Client {
   
    public String runClient(String split){
        String res = "a";
        Socket entrada = null;
        
        try{
            //creates socket
            entrada = new Socket("127.0.0.1" , 3030);
            
            //sends message
            DataOutputStream dos = new DataOutputStream(entrada.getOutputStream());
            dos.writeUTF(split);
            
            //receives message
            DataInputStream dis = new DataInputStream(entrada.getInputStream());
            res = dis.readUTF();
            //closes everyting
            dos.close();
            dis.close();   
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(entrada != null){
            try{
                entrada.close();
            }catch(IOException e){
                
            }
        }

        return res;
    }
}
    

