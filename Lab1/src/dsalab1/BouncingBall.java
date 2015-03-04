/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsalab1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author fhp0351
 */
public class BouncingBall {

    public static Random rand;
    public static JFrame frame;

    public BouncingBall() {

    }

    public static void main(String[] args) {
        rand = new Random();

        frame = new JFrame();
        
        Ball ball1 = new Ball(rand.nextDouble() * 749, rand.nextDouble() * 349,
                rand.nextDouble(), rand.nextDouble(), 5, 20);
        Ball ball2 = new Ball(rand.nextDouble() * 749, rand.nextDouble() * 349,
                rand.nextDouble(), rand.nextDouble(), 5, 50);

        Thread thread1 = new Thread(ball1);
        Thread thread2 = new Thread(ball2);

        
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ball1);
        frame.add(ball2);
        frame.pack();
        frame.setVisible(true);
        
        thread1.start();
        thread2.start();
    }

}
