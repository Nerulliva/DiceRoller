package it.app.logic;

import java.util.Random;

public class Roller {
    private int[]risultati;

    public String roll(int nDadi,String tDadi){
        int res = 0;
        risultati = new int[nDadi];
        int tipoDado = Integer.parseInt(tDadi.substring(1));
        Random rand = new Random();

        for(int i=0;i<nDadi;i++){
            int value = (rand.nextInt(tipoDado)) +1;
            res += value;
            risultati[i] = value;
        }
        return String.valueOf(res);
    }

    public String printRisultati(){
        String res = "";
        for(int i=0;i<risultati.length;i++){
            if(i == risultati.length - 1){
                res += risultati[i];
            } else if(i == 8 || i == 17){
                res += risultati[i]+" +  \n";
            }else{
                res += risultati[i] + " + ";
            }
        }
        return res;
    }
}
