/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guardado;

/**
 *
 * @author LN710Q
 */
import Treads.AnimalThread;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui extends JFrame{
    private JLabel[] Labels;
    private JButton Inicio;
    private String[] Nombres = {"Canguro", "Tortuga", "Dragon"};
    
    public Gui(){
        super("Carrera de animales");
        initialComponents();
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                new Gui().setVisible(true);
            }
        });
    }
    public void initialComponents(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout (null);
        
        Labels = new JLabel[3];
        Inicio = new JButton("Inicio");
        Container container = getContentPane();
        
        for (int i= 0; i < 3; i++){
            Labels[i] = new JLabel();
            Labels[i].setIcon(new ImageIcon(getClass().getResource(Nombres[i]+".gif")));
            Labels[i].setBounds(10,(i*220)+10,200,200);
            container.add(Labels[i]);
    }
    Inicio.setBounds(10, 0, 100, 30);
    container.add(Inicio);
    Inicio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                AnimalThread canguro = new AnimalThread ("Canguro", Labels[0].getX(), Labels[0].getY(), 510,Labels[0]);
                AnimalThread tortuga = new AnimalThread ("Tortuga", Labels[1].getX(), Labels[1].getY(), 510, Labels[1]);
                AnimalThread dragon = new AnimalThread("Dragon", Labels[2].getX(), Labels[2].getY(),510, Labels[2]);
                canguro.start();
                tortuga.start();
                dragon.start();
            }
    
    });
    setSize(700, 650);
    }
   }