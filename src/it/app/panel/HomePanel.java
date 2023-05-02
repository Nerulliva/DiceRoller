package it.app.panel;

import it.app.logic.Roller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    private JLabel l_nDadi;
    private JLabel l_tDadi;
    private JLabel  l_risultato;
    private JSpinner sp_nDadi;
    private JComboBox cb_tDadi;
    private JTextField tf_risultato;
    private JTextArea tf_risultati;
    private JButton roll;

    public HomePanel(){
        super();
        setBounds(25, 10, 300, 400);
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        init();
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
       // JComponent editor = sp_nDadi.getEditor();
        JSpinner.DefaultEditor spEditor = (JSpinner.DefaultEditor) sp_nDadi.getEditor();
        spEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        spEditor.getTextField().setEditable(false);
        this.add(sp_nDadi);

        cb_tDadi = new JComboBox(new String[]{"d4","d6","d8","d10","d12","d20","d100"});
        cb_tDadi.setBounds(155,100,100,30);
        // allineamento center item combobox
        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        cb_tDadi.setRenderer(listRenderer);
        this.add(cb_tDadi);

        l_risultato = new JLabel("Risultato");
        l_risultato.setBounds(125,150,100,30);
        this.add(l_risultato);

        tf_risultato = new JTextField();
        tf_risultato.setEditable(false);
        tf_risultato.setBounds(100,185,100,30);
        tf_risultato.setHorizontalAlignment(JTextField.CENTER);
        this.add(tf_risultato);

       // tf_risultati = new JTextField()
        tf_risultati = new JTextArea();
        tf_risultati.setEditable(false);
        tf_risultati.setBounds(25,220,250,100);
        //tf_risultati.setHorizontalAlignment(JTextField.CENTER);
        this.add(tf_risultati);

        roll = new JButton("Tira");
        roll.setBounds(100,350,100,50);
        this.add(roll);

        roll.addActionListener(e ->{
            Roller roller = new Roller();
            int nDadi = (int) sp_nDadi.getValue();
            String tdadi = (String) cb_tDadi.getItemAt(cb_tDadi.getSelectedIndex());
            tf_risultato.setText(roller.roll(nDadi,tdadi));
            tf_risultati.setText(roller.printRisultati());
        });
    }
}


// per la prossima volta cambio colore tipo 1 rosso e 20 verde
//  tasto reset