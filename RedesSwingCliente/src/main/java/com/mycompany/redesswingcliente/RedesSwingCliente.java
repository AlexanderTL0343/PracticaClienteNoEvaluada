/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.redesswingcliente;

/**
 *
 * @author alext
 */
public class RedesSwingCliente {

    public static void main(String[] args) {
        Client client = new Client("127.0.0.1", 6060);
        client.runClient();
    }
}
