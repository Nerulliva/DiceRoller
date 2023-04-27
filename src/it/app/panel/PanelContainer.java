package it.app.panel;

import javax.swing.*;
import java.awt.*;

public class PanelContainer extends JPanel {

    private HomePanel homePanel;

    public PanelContainer(){
        super();
        setLayout(new GridLayout());
        setBounds(100,100,300,400);
        homePanel = new HomePanel();
        add(homePanel);
//        setSize(500,500);
        //this.homePanel = (HomePanel) panel;
    }
}
