package it.app.panel;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class HomePanel extends JPanel {

    private JButton button;

    public HomePanel(){
        //super();
        setBounds(25, 10, 290, 400);
        setBackground(Color.ORANGE);
        setLayout(new GridLayout());
        button = new JButton("CONFERMA");
        button.setBounds(50,50,100,100);
        add(button);
    }

//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2 = (Graphics2D) g;
//        int y2 = (int)(40 * Math.random());
//        Line2D line = new Line2D.Double(10, 10, 60, y2);
//        Rectangle2D rectangle = new Rectangle2D.Double(200, 120, 70, 30);
//        Ellipse2D oval = new Ellipse2D.Double(400, 200, 40, 60);
//        g2.draw(line);
//        g2.setPaint(Color.RED);
//        g2.fill(rectangle);
//        g2.setPaint(Color.ORANGE);
//        g2.fill(oval);
//    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        Graphics2D g2 = (Graphics2D) g;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        GradientPaint gradientPaint = new GradientPaint(0, 0, Color.decode("1CB5E0"), 0, getHeight(), Color.decode("#000046"));
//        g2.setPaint(gradientPaint);
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
//        g2.fillRect(getWidth() - 20, 0, getWidth(), getHeight());
//        super.paintComponent(g);
//    }
}
