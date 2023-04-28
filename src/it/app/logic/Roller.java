package it.app.logic;

import java.util.Random;

public class Roller {

    public int roll(int nDadi, String tDadi){
        Random rand = new Random();
        int dado = Integer.parseInt(tDadi.substring(1));
        int sum = 0;
        for(int i=0;i<nDadi;i++){
            sum += (rand.nextInt(dado)+1);
        }
        return sum;
    }
}
