package com.example.buster.dicerolling.Entities;

/**
 * Created by Buster on 04-03-2016.
 */
public class Dice {

    private int faceValue;

    public Dice(){
        roll();
    }

    public void roll(){
         faceValue = (int)(Math.random()*6) + 1;
    }

    public int getFaceValue(){
        return faceValue;
    }
}
