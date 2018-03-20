package com.ssaxena36.quizzer.util;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssaxena36.quizzer.Property_detail;
import com.ssaxena36.quizzer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ssaxena36 on 20/3/18.
 */

public class ShortlistedAdapter extends RecyclerView.Adapter<ShortlistedAdapter.MyViewHolder> {
private Context context;
private List<CompanyInfo> companyInfoList;
public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView image;
    View bg;
    boolean selected;
    TextView address, price, bed, shower, sqft;
    public MyViewHolder(View view) {
        super(view);
        selected = false;
        image = view.findViewById(R.id.image);
        price = view.findViewById(R.id.price);
        bed = view.findViewById(R.id.bed);
        address = view.findViewById(R.id.address);
        shower = view.findViewById(R.id.shower);
        sqft = view.findViewById(R.id.sqft);
        bg = view.findViewById(R.id.bg);
    }
}

    public ShortlistedAdapter(Context mainActivityContacts,List<CompanyInfo> moviesList) {
        this.companyInfoList = moviesList;
        this.context = mainActivityContacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_property, parent, false);
        return new MyViewHolder(itemView);
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
    final CompanyInfo movie = companyInfoList.get(position);
        holder.price.setText(movie.getPrice());
        holder.bed.setText(movie.getBed());
        holder.shower.setText(movie.getShower());
        holder.sqft.setText(movie.getSqrft());
        holder.address.setText(movie.getAddress());
        holder.image.setImageResource(movie.getImage());
        holder.bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, Property_detail.class);
                i.putExtra("price",movie.getPrice());
                i.putExtra("address",movie.getAddress());
                i.putExtra("bed",movie.getBed());
                i.putExtra("bath",movie.getShower());
                i.putExtra("sqft",movie.getSqrft());
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return companyInfoList.size();
    }
}
