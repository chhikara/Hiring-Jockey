package com.ssaxena36.quizzer.util;

import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ssaxena36.quizzer.R;

/**
 * Created by ssaxena36 on 27/1/18.
 */

public class DialogAdapter extends ArrayAdapter<String> {

    private final AppCompatActivity context;
    private final String[] web;
    private Typeface custom_font;
    public DialogAdapter(AppCompatActivity context,
                         String[] web) {
        super(context, R.layout.listadap, web);
        this.context = context;
        this.custom_font = Typeface.createFromAsset(context.getAssets(),  "fonts/second.ttf");
        this.web = web;
    }
    @NonNull
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.listadap, null, true);
        TextView txtTitle = rowView.findViewById(R.id.heighttext);
        txtTitle.setText(web[position]);
        //txtTitle.setText("Hi.");
        txtTitle.setTypeface(custom_font);
        return rowView;
    }
}

