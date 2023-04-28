package it.app.panel;

import it.app.logic.Roller;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {
    private JLabel l_nDadi;
    private JLabel l_tDadi;
    private JLabel  l_risultato;
    private JSpinner sp_nDadi;
    private JComboBox cb_tDadi;
    private JTextField tf_risultato;
    private JButton roll;
    private Roller roller = new Roller();

    public HomePanel(){
        super();
        setBounds(25, 10, 300, 400);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        init();
        action();
    }

    private void init(){
        l_nDadi = new JLabel("Numero Dadi");
        l_nDadi.setBounds(50,50,100,30);
        this.add(l_nDadi);

        l_tDadi = new JLabel("Tipo Dado");
        l_tDadi.setBounds(50,100,100,30);
        this.add(l_tDadi);

        SpinnerNumberModel value = new SpinnerNumberModel(1,1,20,1);
        sp_nDadi = new JSpinner(value);
        sp_nDadi.setBounds(155,50,100,30);
        this.add(sp_nDadi);

        cb_tDadi = new JComboBox(new String[]{"d4","d6","d8","d10","d12","d20","d100"});
        cb_tDadi.setBounds(155,100,100,30);
        this.add(cb_tDadi);

        l_risultato = new JLabel("Risultato");
        l_risultato.setBounds(125,150,100,30);
        this.add(l_risultato);

        tf_risultato = new JTextField();
        tf_risultato.setEditable(false);
        tf_risultato.setBounds(100,185,100,30);
        this.add(tf_risultato);

        roll = new JButton("Tira");
        roll.setBounds(100,250,100,50);
        this.add(roll);
    }

    private void action(){
        roll.addActionListener(e -> {
            int numDadi = (int) sp_nDadi.getValue();
            String tipoDadi = (String) cb_tDadi.getItemAt(cb_tDadi.getSelectedIndex());
            String res = String.valueOf(roller.roll(numDadi,tipoDadi));
            tf_risultato.setText(res);
        });
    }
}
