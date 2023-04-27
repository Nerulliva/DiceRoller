package it.app;

import it.app.panel.HomePanel;
import it.app.panel.PanelContainer;

import javax.swing.*;
import java.awt.*;

public class App{

    private JFrame frame;
    private HomePanel homePanel;
    private JPanel container;

    private ViewportLayout viewportLayout;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    App window = new App();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public App() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 350, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
//        frame.getContentPane().add(container);
//        panel1 = new JPanel();
//        panel1.add(homePanel);
        frame.getContentPane().add(container);
        container = new PanelContainer();

    }

   private void createUIComponents() {
       //homePanel = new HomePanel();
       container = new PanelContainer();
       //container.add(homePanel);
       //System.out.println(container != null);
       //frame.add(container);


        // TODO: place custom component creation code here
    }
}
