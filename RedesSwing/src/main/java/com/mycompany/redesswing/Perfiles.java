/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redesswing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexander
 */
public class Perfiles {
    String respuesta="a";
    String perfil[];

    public String getRespuesta() {
        return respuesta;
    }
    
    public void Inicio(){
        try{
            File documento = new File("Perfiles.txt");
            Scanner  scan = new Scanner(documento);
            String split = scan.nextLine();
            
            perfil= split.split("$");
        }catch(FileNotFoundException e){
            JOptionPane.showInputDialog(" Archivo no encontrado ");
        }     
    }
    
    public void Revision(String split){
        String[] auxperfil = split.split("#");
        if(perfil.length == 2 && auxperfil.length == perfil.length){
            if(auxperfil[0].equals(perfil[0]) && auxperfil[1].equals(perfil[1])){
                respuesta = "b";           
        }else{
            respuesta="a";
        }
        
        }
    }
}
    
   

