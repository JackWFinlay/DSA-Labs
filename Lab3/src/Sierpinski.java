import javax.swing.*;

/**
 * Created by jack on 17/03/15.
 */
public class Sierpinski {
    public static TurtlePanel turtle;

    public static void main(String[] args) {
        turtle = new TurtlePanel();
        turtle.setTurtleIsVisible(true);
        turtle.setAutoRepaint(true);

        // Move to top of frame.
        turtle.penUp();
        turtle.moveTo(0, 10);
        turtle.penDown();
        turtle.turn(-90);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(turtle);
        frame.pack();
        frame.setVisible(true);

        sierpinskiTriangle(20.0, 10);

    }

    public static void sierpinskiTriangle(Double size, int resolution) {
        if (resolution == 0) {

            turtle.turn(-30);
            turtle.forward(size);
            turtle.turn(120);
            turtle.forward(size);
            turtle.turn(120);
            turtle.forward(size);
            turtle.turn(150);

        } else {

            sierpinskiTriangle(size / 2, resolution - 1);
            turtle.turn(-30);
            turtle.forward(size / 2);
            turtle.turn(30);
            sierpinskiTriangle(size / 2, resolution - 1);
            turtle.turn(90);
            turtle.forward(size / 2);
            turtle.turn(-90);
            sierpinskiTriangle(size / 2, resolution - 1);
            turtle.turn(-150);
            turtle.forward(size / 2);
            turtle.turn(150);

        }

    }
}
