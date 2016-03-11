package com.example.buster.dicerolling.Entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Buster on 04-03-2016.
 */
public class DiceCollection {
    private List<Dice> dices;
    private Date date;

    public DiceCollection(){
        dices = new ArrayList<>();
        date = new Date();
    }

    public List<Dice> getDices(){
        return dices;
    }
    private Date getD(){
        return date;
    }

    public String getDate(){
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String s= dt.format(getD());

        return s;
    }

    public void addDice(Dice dice){
        dices.add(dice);
    }





}
