/** Ryley's Pepsi Machine GUI
 * Student Name: Ryley Carlson
 * CSC372 Module 3 Discussion 3
 * Date: 2026-04-01
 * Program: PepsiMachine.java
 * Description: This program creates a simple GUI for a Pepsi vending machine using Java Swing.
 *  It features three buttons for different Pepsi options: "Pepsi", "Diet Pepsi", and "Wild Cherry".
 *  The layout of the buttons is managed using a FlowLayout, which centers the buttons and provides spacing between them.
 *  The GUI is displayed in a window with the title " Ryley's Pepsi Vending Interface".
 */

import java.awt.*;
import javax.swing.*;

public class PepsiMachine {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ryley's Pepsi Vending Interface");
        JPanel panel = new JPanel();

        // One of the ways to set the layout: Passing the object into setLayout, I believe this is the more common way to do it.
        // Plus,it allows us to set the parameters of the layout in the constructor, which is nice.
        // The other way is to create the layout object separately and then pass it into setLayout, but that just seems like an extra step to me.
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Adding our "Buttons" (Components)
        panel.add(new JButton("Pepsi"));
        panel.add(new JButton("Diet Pepsi"));
        panel.add(new JButton("Wild Cherry"));

        frame.add(panel);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}