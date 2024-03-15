/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.redesswingcliente;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author Alexander
 */
public class LoginSwing {
    Client usuario = new Client();

    private JFrame ventana;
    private JPanel panel;
    private JTextField nombre;
    private JTextField contra;
    private JLabel nombreLabel;
    private JLabel contraLabel;
    private JButton confirmarBtn;
    private JLabel sesionLabel;

    public LoginSwing() {
        ventana = new JFrame("Inicio De Sesion");
        panel = new JPanel();
        nombre = new JTextField();
        contra = new JTextField();
        nombreLabel = new JLabel("Usuario:");
        contraLabel = new JLabel("Contraseña:");
        confirmarBtn = new JButton("Confirmar");
        sesionLabel = new JLabel();
    }

    public void activar() {
        ventana.setSize(1000, 600);
        panel.setLayout(null);
        panel.setBackground(Color.orange);
        
        contraLabel.setBounds(400, 170, 200, 25);
        contraLabel.setForeground(Color.black);
        contra.setBounds(500, 170, 200, 25);
        
        confirmarBtn.setBounds(450, 500, 100, 40);
        
        nombreLabel.setBounds(400, 130, 200, 25);
        nombre.setForeground(Color.black);
        nombre.setBounds(500, 130, 200, 25);
        

        confirmarBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String auxnombre = nombre.getText();
                String auxcontra = contra.getText();
                String aux = usuario.runClient(auxnombre + "$" + auxcontra);
                if (aux.equals("b")) {
                     sesionLabel.setText("Sesion iniciada correctamente");
                } else if (aux.equals("a")) {
                    sesionLabel.setText("Usuario o contraseña incorrecto");

                }
            }

        });

        panel.add(nombre);
        panel.add(nombreLabel);
        panel.add(contraLabel);
        panel.add(contra);
        panel.add(confirmarBtn);
        panel.add(sesionLabel);

        ventana.add(panel);

        ventana.setDefaultCloseOperation(3);
        ventana.setResizable(false);
        ventana.setVisible(true);
    }

}
