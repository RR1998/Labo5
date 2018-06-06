/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Treads;

import javax.swing.*;

/**
 *
 * @author LN710Q
 */
public class AnimalThread extends Thread {
    private String Nombre;
    private int Limite;
    private JLabel animal;
    private int x;
    private int y;

    public AnimalThread(String Nombre, int x, int y, int Limite, JLabel animal) {
        this.Nombre = Nombre;
        this.Limite = Limite;
        this.animal = animal;
        this.x = x;
        this.y = y;
    }
    public AnimalThread() {
    }
    @Override
    public void run (){
        for (int i = x; i < this.Limite ; i += 10){
            System.out.println(this.Nombre+ " avanza");
            this.animal.setLocation(i,y);
            if (this.Nombre == "tortuga"){
                try {
                    sleep(100);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            else{
                try{
                    sleep(500);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        for (int i = this.Limite -1; i > this.Limite - (this.Limite+1); i -= 10){
            System.out.println(this.Nombre+" Viene de regreso alv");
            this.animal.setLocation(i,y);
            try{
                sleep(100);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        yield();
        System.out.println(this.Nombre+" a llegado a la meta");

    }
    
}
