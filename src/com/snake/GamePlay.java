package com.snake;

import com.sun.org.apache.regexp.internal.REDebugCompiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;


public class GamePlay extends JPanel implements ActionListener, KeyListener {
    private Timer t = new Timer(3, this);
    private double x = 40;
    private double y = 40;
    private double xA = 40;
    private double yA = 40;
    private double velx = 0;
    private double vely = 0;
    private int count = 0;

    GamePlay() {
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;
        Rectangle2D rectangle2D = new Rectangle2D.Double(x,y,15,15);
        g2.setPaint(Color.BLACK);
        g2.fill(rectangle2D);
    }



    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        updateUI();
        checkTouch();
        x += velx;
        y += vely;
    }

    @Override
    protected void paintChildren(Graphics graphics) {
        super.paintChildren(graphics);
        Graphics2D g2 = (Graphics2D) graphics;
        double px = xA;
        double py = yA;
        if( (x < px+5) && (x > px-5) ){
            if((y < py+5) && (y > py-5)) {
                Random random = new Random();
                xA = random.nextInt(601);
                yA = random.nextInt(601);
                count++;
                System.out.println(count);
            }
        }
        Rectangle2D apple = new Rectangle2D.Double(xA,yA,15,15);
        g2.setPaint(Color.RED);
        g2.fill(apple);
    }


    private void up(){
        vely = -0.5;
        velx = 0;
    }

    private void down(){
        vely = 0.5;
        velx = 0;
    }

    private void left(){
        vely = 0;
        velx = -0.5;
    }
    private void right(){
        vely = 0;
        velx = 0.5;
    }

    private void checkTouch(){
        if ( (x >= 0 && x <= 600) && y == 0){ System.exit(0);}
        if ( (y >= 0 && y <= 600) && x == 0 ){System.exit(0);}
        if ( (x >= 0 && x <= 600) && y == 600 ){System.exit(0);}
        if ( (y >= 0 && y <= 600) && x == 600 ){System.exit(0);}
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
