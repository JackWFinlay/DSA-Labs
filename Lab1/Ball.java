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
public class Ball extends JPanel {

    private double centre_x;
    private double centre_y;
    private double direction_x;
    private double direction_y;
    private double velocity;
    private double r;
    private Color color;
    private Random rand;
    private JFrame frame;
    private String name;

    // Overide default constructor
    public Ball(){}

    public Ball(double centre_x, double centre_y, double direction_x,
                double direction_y, double velocity, double r){

        this.rand = new Random();
        this.centre_x = centre_x;
        this.centre_y = centre_y;
        this.direction_x = direction_x;
        this.direction_y = direction_y;
        this.direction_x = direction_x;
        this.direction_y = direction_y;
        this.velocity = velocity;
        this.r = r;
        this.color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        this.setBackground(new Color(0, 0, 0, 0));
        this.setPreferredSize(new Dimension(BouncingBall.frame.getSize()));
    }

    public double getCentre_x() {
        return centre_x;
    }

    public double getCentre_y() {
        return centre_y;
    }

    public double getDirection_x() { return direction_x; }

    public void setDirection_x(double direction) { this.direction_x = direction; }

    public double getDirection_y() {
        return direction_y;
    }

    public void setDirection_y(double direction) { this.direction_y = direction; }

    public double getVelocity() {
        return velocity;
    }

    public double getR() {
        return r;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(color);
        // Draw the ellipse
        g2d.fill(new Ellipse2D.Double(centre_x, centre_y, r, r));

    }

    public void move(){

        // Normalize directions.
        double normalizedDirection_x = normalizeDirection(direction_x);
        double normalizedDirection_y = normalizeDirection(direction_y);

        // Calculate new positions.
        centre_x = (getCentre_x() + (velocity * normalizedDirection_x));
        centre_y = (getCentre_y() + (velocity * normalizedDirection_y));

        // Detect wall collision.
        if ((centre_x <= 0) || ((centre_x + r) >= this.getSize().width)) {
            direction_x *= -1.0;
            color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        }
        if ((centre_y <= 0) || ((centre_y + r) >= this.getSize().height)) {
            direction_y *= -1.0;
            color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat());
        }
        System.out.printf("%s position (%f,%f), direction (%f,%f), velocity (%f), radius (%f) \n", Thread.currentThread().getName(),
                centre_x, centre_y, direction_x, direction_y, velocity, r );

    }

    private double normalizeDirection (double i) {
        return (i/(Math.sqrt((Math.pow(direction_x,2))+(Math.pow(direction_y,2)))));
    }

}