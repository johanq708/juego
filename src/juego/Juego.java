/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author Estudiante
 */
public class Juego extends JFrame{

    public Juego(){
        add(new miPanel());
    }
    public static void main(String[] args) {
        Juego frame = new Juego();
        frame.setTitle("mi juego");
        frame.setSize(1024, 512);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    class miPanel extends JPanel implements ActionListener{
        private int sec=0;
        private int y;
        private Timer timer;
        
        public miPanel(){
        addKeyListener(new Ta());
        setFocusable(true);
        timer=new Timer(1000, this);
        timer.start();
    }
        protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Image fondo= loadImage("blue_background.png");
        g.drawImage(fondo, 0, 0,1024,512, null);
        
        Image nube= loadImage("clouds.png");
        g.drawImage(nube, 0, 10, null);
        g.drawImage(nube, 335, 10, null);
        g.drawImage(nube, 670, 10, null);
        
        Image piso=loadImage("ground_loop.png");
        g.drawImage(piso,0,400,null);
        g.drawImage(piso,112,400,null);
        g.drawImage(piso,224,400,null);
        g.drawImage(piso,336,400,null);
        g.drawImage(piso,448,400,null);
        g.drawImage(piso,560,400,null);
        g.drawImage(piso,672,400,null);
        g.drawImage(piso,784,400,null);
        g.drawImage(piso,896,400,null);
        
        Image piedra=loadImage("stone.png");
        g.drawImage(piedra, 600, 350, this);
        g.drawImage(piedra, 200, 0+y, this);
        g.drawImage(piedra, 500, y-200, this);
        g.drawImage(piedra, 900, y-400, this);
        g.drawImage(piedra, 300, y-600, this);
        g.drawImage(piedra, 700, y-800, this);
        g.drawImage(piedra, 100, y-1000, this);
        
        Image quieto=loadImage("standing.png");
        g.drawImage(quieto,10,277,118,410,0,0,118,133,this);
        
        Image mover=loadImage("walking.png");
        g.drawImage(mover,10+x,277);
    }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(sec==1){
                sec=0;
            }else{
                sec++;
            }
            y+=4;
            repaint();
        }
        private class Ta extends KeyAdapter{
            
        }
        public Image loadImage(String nombre){
        ImageIcon ii=new ImageIcon(nombre);
        Image image=ii.getImage();
        return image;
    }
    }
}
