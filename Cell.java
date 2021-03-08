package com.vulture;

import javax.swing.*;
import java.awt.*;

public class Cell extends JPanel {
    final private int size = 10;
    public final int x = 1300;
    public final int y = 700;
    // private Color color;
    //private Graphics g;
    public boolean[][] life = new boolean[x / size][y / size];

    public Cell() {
        setSize(1300, 700);
        setLayout(null);
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        grid(g);
    }

    private void grid(Graphics g) {
        for (int i = 0; i < x / size; i++) {
            g.drawLine(0, i * size, x, i * size);// we wanna draw the rows first alright x)
            g.drawLine(i * size, 0, i * size, y);//now that s for columns
        }
    }
}

