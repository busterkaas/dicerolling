package com.example.buster.dicerolling.DicesController;

import com.example.buster.dicerolling.Entities.DiceCollection;

import java.util.ArrayList;

/**
 * Created by Buster on 04-03-2016.
 */
public class DiceController {

    private static DiceController dController;

    private ArrayList<DiceCollection> collections;


    private DiceController(){
        collections = new ArrayList<DiceCollection>();
    }

    public static DiceController getInstance(){
        if(dController==null){
            dController = new DiceController();
        }
        return dController;
    }

    public ArrayList<DiceCollection> getAll(){
        return collections;
    }

    public void addCollection(DiceCollection collection){
        collections.add(collection);
    }

    public void clearAll(){
        collections = new ArrayList<DiceCollection>();
    }


}
