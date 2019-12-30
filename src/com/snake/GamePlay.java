package com.snake;

import com.sun.org.apache.regexp.internal.REDebugCompiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;


public class GamePlay extends JPanel implements ActionListener, KeyListener {
    private Timer t = new Timer(5, this);
    private double x = 0;
    private double y = 0;
    private double velx = 0;
    private double vely = 0;
    

    public GamePlay() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;
        Ellipse2D ellipse = new Ellipse2D.Double(x,y,40,40);
        g2.setPaint(Color.BLACK);
        g2.fill(ellipse);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        repaint();
        x += velx;
        y += vely;
    }

    public void up(){
        vely = -0.5;
        velx = 0;
    }

    public void down(){
        vely = 0.5;
        velx = 0;
    }

    public void left(){
        vely = 0;
        velx = -0.5;
    }
    public void right(){
        vely = 0;
        velx = 0.5;
    }
    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_UP){
            up();
        }if(code == KeyEvent.VK_DOWN){
            down();
        }if(code == KeyEvent.VK_RIGHT){
            right();
        }if(code == KeyEvent.VK_LEFT){
            left();
        }
    }
    public void keyTyped (KeyEvent e){}
    public void keyReleased (KeyEvent e){}
}
