/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.redesswing;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author alext
 */
public class RedesSwingServidor {

    public static void main(String[] args) {
        Server[] hilos = new Server[3846];
        int cantidad = 0;

        ServerSocket serverSock = null;
        try {
            serverSock = new ServerSocket(5432);
        } catch (IOException e) {
        }
        while (cantidad < 3846) {
            Socket s = null;

            try {
                s = serverSock.accept();
                hilos[cantidad] = new Server(s);
                hilos[cantidad].start();
                cantidad++;
            } catch (IOException e) {

            }
        }
    }
}

