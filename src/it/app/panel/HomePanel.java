package it.app.panel;

import it.app.customSwing.MyButton;
import it.app.logic.Roller;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;

public class HomePanel extends JPanel {
    private JLabel l_nDadi;
    private JLabel l_tDadi;
    private JLabel  l_risultato;
    private JSpinner sp_nDadi;
    private JComboBox cb_tDadi;
    private JTextField tf_risultato;
    private JTextPane tp_risultati;
    private JButton roll;
    private JLabel l_tot;
    private MyButton saluta;
    private MyButton insulta;

    public HomePanel(){
        super();
        setBounds(18, 10, 300, 400);
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

       // tf_risultati = new JTextField()
        tp_risultati = new JTextPane();
        tp_risultati.setEditable(false);
        tp_risultati.setBounds(25,185,250,100);
        //tf_risultati.setHorizontalAlignment(JTextField.CENTER);
        this.add(tp_risultati);

        l_tot = new JLabel("Totale");
        l_tot.setBounds(120,290,100,30);
        this.add(l_tot);

        tf_risultato = new JTextField();
        tf_risultato.setEditable(false);
        tf_risultato.setBounds(176,290,100,30);
        tf_risultato.setHorizontalAlignment(JTextField.CENTER);
        this.add(tf_risultato);

        roll = new JButton("Tira");
        roll.setBounds(100,350,100,50);
        this.add(roll);

        roll.addActionListener(e ->{
            tp_risultati.setText(" ");
            Roller roller = new Roller();
            int nDadi = (int) sp_nDadi.getValue();
            String tdadi = (String) cb_tDadi.getItemAt(cb_tDadi.getSelectedIndex());
            tf_risultato.setText(roller.roll(nDadi,tdadi));
            //tp_risultati.setText(roller.printRisultati());


            try{
                setStyle(roller.getRisultai(),Integer.parseInt(tdadi.substring(1)) );
            }catch(BadLocationException ex){
                System.out.println(ex.getMessage());
            }

        });
    }

    public void setStyle(String [] risultati, int tipoDado) throws BadLocationException {
        MutableAttributeSet verde = new SimpleAttributeSet(tp_risultati.getInputAttributes());
        StyleConstants.setForeground(verde, Color.GREEN);

        MutableAttributeSet rosso = new SimpleAttributeSet(tp_risultati.getInputAttributes());
        StyleConstants.setForeground(rosso, Color.RED);

        MutableAttributeSet nero = new SimpleAttributeSet(tp_risultati.getInputAttributes());
        StyleConstants.setForeground(nero, Color.BLACK);

        for(int i =0; i<risultati.length; i++){
            String str = risultati[i];

            if(str.equals("1")){
                tp_risultati.getStyledDocument().insertString(tp_risultati.getDocument().getLength(),str,rosso);
            }else if(str.equals(String.valueOf(tipoDado))){
                tp_risultati.getStyledDocument().insertString(tp_risultati.getDocument().getLength(),str,verde);
            }else{
                tp_risultati.getStyledDocument().insertString(tp_risultati.getDocument().getLength(),str,nero);
            }

            if(i != risultati.length-1){
                tp_risultati.getStyledDocument().insertString(tp_risultati.getDocument().getLength()," + ",nero);
            }
        }
    }

}


