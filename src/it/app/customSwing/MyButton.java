package it.app.customSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {

    private String nome;
    public MyButton(String nome, int x, int y, int width, int height ){
        super();
        this.nome = nome;
        setBounds(x,y,width,height);
        addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(this.nome){
            case "SALUTA" : System.out.println("ciao");
                break;
            case "INSULTA" : System.out.println("Vaffanculo");
                break;
        }
    }
}
