package com.example.buster.dicerolling;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.buster.dicerolling.DicesController.DiceController;

public class History extends AppCompatActivity {

    DiceController dController;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        dController = DiceController.getInstance();

        Button btnClear = (Button)findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearHistory();
            }
        });

        Button btnBack = (Button)findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ListView lv = (ListView)findViewById(R.id.lvHistory);
        CustomListViewAdapter adapter = new CustomListViewAdapter(getApplicationContext(), dController.getAll());
        lv.setAdapter(adapter);

    }
    private void clearHistory(){
        dController.clearAll();
        finish();
        startActivity(getIntent());
    }


}
