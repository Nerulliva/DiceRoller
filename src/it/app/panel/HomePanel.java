package it.app.panel;

import it.app.customSwing.MyButton;
import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel {

    private JLabel l_nDadi;
    private JLabel l_tDadi;
    private JLabel  l_risultato;
    private JLabel l_bonus;
    public static JSpinner sp_nDadi;
    public static JSpinner sp_bonus;
    public static JComboBox cb_tDadi;
    public static JTextField tf_risultato;
    public static JTextPane tp_risultati;
    private MyButton roll;
    private JLabel l_tot;

    public HomePanel(){
        super();
        setBounds(18, 10, 300, 570);
//        setBounds(18, 10, 300, 400); // originale
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        init();
    }

    private void init(){
        // SPINNER NUMERO DATI
        l_nDadi = new JLabel("Numero Dadi");
        l_nDadi.setBounds(50,50,100,30);
        this.add(l_nDadi);

        SpinnerNumberModel value = new SpinnerNumberModel(1,1,20,1);
        sp_nDadi = new JSpinner(value);
        sp_nDadi.setBounds(155,50,100,30);
       // JComponent editor = sp_nDadi.getEditor();
        JSpinner.DefaultEditor spEditor = (JSpinner.DefaultEditor) sp_nDadi.getEditor();
        spEditor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        spEditor.getTextField().setEditable(false);
        this.add(sp_nDadi);

        // COMBOBOX TIPO DADI
        l_tDadi = new JLabel("Tipo Dado");
        l_tDadi.setBounds(50,100,100,30);
        this.add(l_tDadi);

        cb_tDadi = new JComboBox(new String[]{"d4","d6","d8","d10","d12","d20","d100"});
        cb_tDadi.setBounds(155,100,100,30);
        // allineamento center item combobox
        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER); // center-aligned items
        cb_tDadi.setRenderer(listRenderer);
        this.add(cb_tDadi);

        // SPINNER BONUS
        l_bonus = new JLabel("Bonus");
        l_bonus.setBounds(50,150,100,30);
        this.add(l_bonus);

        SpinnerNumberModel valueBonus = new SpinnerNumberModel(0,-10,20,1);
        sp_bonus = new JSpinner(valueBonus);
        sp_bonus.setBounds(155, 150, 100,30);
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) sp_bonus.getEditor();
        editor.getTextField().setHorizontalAlignment(JTextField.CENTER);
        editor.getTextField().setEditable(false);
        this.add(sp_bonus);

        /////////////////
        l_risultato = new JLabel("Risultato");
        l_risultato.setBounds(125,200,100,30);
        this.add(l_risultato);

       // tf_risultati = new JTextField()
        tp_risultati = new JTextPane();
        tp_risultati.setEditable(false);
        tp_risultati.setBounds(25,235,250,100);
        //tf_risultati.setHorizontalAlignment(JTextField.CENTER);
        this.add(tp_risultati);

        l_tot = new JLabel("Totale");
        l_tot.setBounds(120,340,100,30);
        this.add(l_tot);

        tf_risultato = new JTextField();
        tf_risultato.setEditable(false);
        tf_risultato.setBounds(176,340,100,30);
        tf_risultato.setHorizontalAlignment(JTextField.CENTER);
        this.add(tf_risultato);

        roll = new MyButton("TIRA",100,400,100,50);
        this.add(roll);
    }

}

//  tasto reset