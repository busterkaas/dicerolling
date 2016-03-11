package com.example.buster.dicerolling;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import com.example.buster.dicerolling.DicesController.DiceController;
import com.example.buster.dicerolling.Entities.Dice;
import com.example.buster.dicerolling.Entities.DiceCollection;

import java.util.ArrayList;

public class RollMain extends AppCompatActivity {

    NumberPicker numberPicker;
    DiceController diceController;
    LinearLayout diceLayout;
    int layoutHeight;
    int layoutWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_main);

        numberPicker = (NumberPicker)findViewById(R.id.numberPicker);
        diceLayout = (LinearLayout)findViewById(R.id.linearL);
        diceLayout.setGravity(Gravity.CENTER);


        Button btnRoll = (Button)findViewById(R.id.btnRoll);
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollIt();
            }
        });

        Button btnHistory = (Button)findViewById(R.id.btnHistory);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHistoryActivity();
            }
        });


        instanciate();
        doIt();
    }

    public void rollIt(){
        int diceAmount = (int)numberPicker.getValue();
        DiceCollection dc = new DiceCollection();
        for(int i = 0; i<diceAmount;i++){
            Dice dice = new Dice();
            dc.addDice(dice);
        }
        diceController.addCollection(dc);
        showDices(dc);

    }
    public void showDices(DiceCollection collection){

        if(diceLayout.getChildCount()>0){
            diceLayout.removeViews (0, diceLayout.getChildCount());
        }

        //code for images
        for(Dice dice : collection.getDices()) {
            ImageView imageView = new ImageView(this);
            imageView = setImage(imageView, dice);


            ViewGroup.LayoutParams imageViewLayoutParams
                    = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            imageView.setLayoutParams(imageViewLayoutParams);

            imageView.getLayoutParams().height = layoutHeight;
            imageView.getLayoutParams().width = layoutWidth/6;
            imageView.setPadding(10, 10, 10, 10);
            imageView.setAnimation(getAnimation());
            diceLayout.addView(imageView);
        }
    }

    public Animation getAnimation(){
        return AnimationUtils.loadAnimation(this, R.anim.myrotate);
    }

    private ImageView setImage(ImageView imageView, Dice dice){
        switch (dice.getFaceValue()){
            case 1:
                imageView.setImageResource(R.drawable.one);
                return imageView;
            case 2:
                imageView.setImageResource(R.drawable.two);
                return imageView;
            case 3:
                imageView.setImageResource(R.drawable.three);
                return imageView;
            case 4:
                imageView.setImageResource(R.drawable.four);
                return imageView;
            case 5:
                imageView.setImageResource(R.drawable.five);
                return imageView;
            case 6:
                imageView.setImageResource(R.drawable.six);
                return imageView;
        }
        return null;
    }

    public void goToHistoryActivity(){
        Intent intent = new Intent(RollMain.this, History.class);
        startActivity(intent);
    }


    public void instanciate(){
        diceController = DiceController.getInstance();
        numberPicker.setMaxValue(6);
        numberPicker.setMinValue(1);
    }

    private void doIt() {
        ViewTreeObserver observer = diceLayout.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                // TODO Auto-generated method stub
                init();
                diceLayout.getViewTreeObserver().removeGlobalOnLayoutListener(
                        this);
            }
        });
    }
    private void init() {
        layoutHeight = diceLayout.getHeight();
        layoutWidth = diceLayout.getWidth();
    }




}
