package com.vulture;

import javax.swing.*;

public class Life extends JFrame{

    public Life(){
        add(new Cell());
        setSize(1300,700);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Life();
    }
}
