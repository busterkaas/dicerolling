package com.example.buster.dicerolling;

import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.buster.dicerolling.Entities.Dice;
import com.example.buster.dicerolling.Entities.DiceCollection;

import java.util.ArrayList;

/**
 * Created by Buster on 04-03-2016.
 */
public class CustomListViewAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<DiceCollection> diceCollections;
    private static LayoutInflater inflater = null;


    public CustomListViewAdapter(Context context, ArrayList<DiceCollection> data)
    {
        mContext = context;
        diceCollections = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return diceCollections.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
        DiceCollection collection = diceCollections.get(position);

        if(convertView==null){
            view = inflater.inflate(R.layout.list_row, null);
        }
        TextView date = (TextView) view.findViewById(R.id.tvDate);
        LinearLayout imgLayout = (LinearLayout) view.findViewById(R.id.layoutImages);

        date.setText(collection.getDate());

        //remove dices from last view
        if(imgLayout.getChildCount()>0){
            imgLayout.removeViews (0, imgLayout.getChildCount());
        }


        //code for images
        for(Dice dice : collection.getDices()){
            ImageView imageView = new ImageView(mContext);
            imageView = setImage(imageView, dice);

            LayoutParams imageViewLayoutParams
                    = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);

            imageView.setLayoutParams(imageViewLayoutParams);

            imageView.setMaxHeight(imgLayout.getHeight());
           // imageView.setMaxWidth(imgLayout.getWidth() / 6);
            imageView.getLayoutParams().height = 75;
            imageView.getLayoutParams().width = 75;
            imageView.setPadding(5, 5, 5, 5);

            imgLayout.addView(imageView);
        }

        return view;
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




}
