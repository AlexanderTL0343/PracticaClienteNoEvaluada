/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.redesswing;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alext
 */
public class RedesSwingServidor {

    public static void main(String[] args) {
       try {
            Server server = new Server();
            server.runServer();
        } catch (IOException ex) {
            Logger.getLogger(RedesSwingServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
