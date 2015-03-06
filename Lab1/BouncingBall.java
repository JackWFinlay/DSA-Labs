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

    public static JFrame frame;

    public BouncingBall() {

    }

    public static void main(String[] args) {
        Random rand = new Random();

        frame = new JFrame();

        // Create balls
        Ball ball1 = new Ball(rand.nextDouble() * 749, rand.nextDouble() * 349,
                rand.nextDouble(), rand.nextDouble(), 5, 50);
        Ball ball2 = new Ball(rand.nextDouble() * 749, rand.nextDouble() * 349,
                rand.nextDouble(), rand.nextDouble(), 5, 50);

        // Set up frame
        frame.setPreferredSize(new Dimension(800, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(ball1);
        frame.add(ball2);
        frame.pack();
        frame.setVisible(true);

        // Perform movement
        while (true) {
            ball1.move();
            ball2.move();

            // Collision detection
            if (Math.abs(ball1.getCentre_x() - ball2.getCentre_x()) <= ball1.getR() ) {
                ball1.setDirection_x(ball1.getDirection_x() * -1);
                ball1.move();
                ball2.setDirection_x(ball2.getDirection_x() * -1);
                ball2.move();
            }

            if (Math.abs(ball1.getCentre_y() - ball2.getCentre_y()) <= ball1.getR() ) {
                ball1.setDirection_y(ball1.getDirection_y() * -1);
                ball1.move();
                ball2.setDirection_y(ball2.getDirection_y() * -1);
                ball2.move();
            }

            // Redraw the frame
            frame.revalidate();
            frame.repaint();
            try {
                // Sleep the thread to reduce frame rate
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}