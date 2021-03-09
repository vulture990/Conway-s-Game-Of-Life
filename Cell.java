package com.vulture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Cell extends JPanel implements ActionListener {
    final private int size = 10;
    public final int x = 1300;
    public final int y = 700;
    // private Color color;
    //private Graphics g;
    public boolean[][] life = new boolean[x / size][y / size];
    public boolean[][] next=new boolean[x/size][y/size];
    boolean runing=true;
    public Cell() {
        setSize(1300, 700);
        setLayout(null);
        new Timer(100,this).start();
        setBackground(Color.BLACK);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        setGrid(g);
        grid(g);
        rules(g);
        //show(g);
    }

    private void grid(Graphics g) {
        for (int i = 0; i < x / size; i++) {
            g.drawLine(0, i * size, x, i * size);// we wanna draw the rows first alright x)
            g.drawLine(i * size, 0, i * size, y);//now that s for columns
        }
    }
    private void setGrid(Graphics g){
        Random r=new Random();
        for(int i=0;i<x/size;i++){
            for(int j=0;j<y/size;j++){
                int rr=r.nextInt(10)+1;
                if(rr<3){
                    life[i][j]=true;
                }
                else{
                    life[i][j]=false;
                }
            }
        }
    }
    private void rules(Graphics g){
        // the rules we r going to implement here are pretty basic in nutshell :
        //a living cell truns into a dead one only and only if it has >3 || 2< less than
        // a dead cell arises from the aches x) if it has exactly three living neighboors
        //let's start first with the edge cases get them outta of our way

            for (int i = 0; i < (x / size) - 1; i++) {
                for (int j = 0; j < (y / size) - 1; j++) {
                    checkNeighboors(i, j);
                }
            }
            life = next;
            show(g);

    }
    private void show(Graphics g) {
        for (int i = 0; i < x / size; i++) {
            for (int j = 0; j < y / size; j++) {
                if (next[i][j]) {
                    g.fillRect(i * size, j * size, size, size);
                }
            }
        }
    }
    private void checkNeighboors(int i,int j){//i & j th positon west l grid okaaye
        //let's start first with the edge cases get them outta of our way
        if(i<1 || i>x/size || j>y/size || j<1){
            next[i][j]=false;
        }
        else{
            if (!life[i][j]) {
                int countLivingCells = 0;
                if (life[i][j - 1]){
                    countLivingCells++;
                }
                 if(life[i][j+1]){
                    countLivingCells++;
                }
                if(life[i-1][j]){
                    countLivingCells++;
                }
                 if(life[i-1][j+1]){
                    countLivingCells++;
                }
                 if(life[i-1][j-1]){
                    countLivingCells++;
                }
                 if(life[i+1][j-1]){
                    countLivingCells++;
                }
                if(life[i+1][j]){
                    countLivingCells++;
                }
                if(life[i+1][j+1]){
                    countLivingCells++;
                }

                if(countLivingCells==3){
                    next[i][j]=true;
                }
                else {
                    next[i][j]=life[i][j];
                }
            }
            else {
                    int deadCells = 0;
                    if (life[i][j - 1]){
                        deadCells++;
                    }
                     if(life[i][j+1]){
                        deadCells++;
                    }
                     if(life[i-1][j]){
                        deadCells++;
                    }
                     if(life[i-1][j+1]){
                        deadCells++;
                    }
                     if(life[i-1][j-1]){
                        deadCells++;
                    }
                     if(life[i+1][j-1]){
                        deadCells++;
                    }
                     if(life[i+1][j]){
                        deadCells++;
                    }
                     if(life[i+1][j+1]){
                        deadCells++;
                    }
                    if(deadCells<2 || deadCells>3){
                        next[i][j]=false;
                    }
                    else{
                        next[i][j]=life[i][j];
                    }
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}

