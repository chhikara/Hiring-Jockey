package com.ssaxena36.quizzer;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ssaxena36.quizzer.util.CompanyInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * Created by Rp on 6/14/2016.
 */
public class RecycleAdapter_propertylist extends RecyclerView.Adapter<RecycleAdapter_propertylist.MyViewHolder> {
    private static HashSet<CompanyInfo> hashSet = new HashSet<>();
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

    public RecycleAdapter_propertylist(Context mainActivityContacts,List<CompanyInfo> moviesList) {
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
        holder.bg.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(holder.selected) {
                    holder.selected = false;
                    holder.bg.setBackground(null);
                    hashSet.remove(movie);
                } else {
                    holder.selected = true;
                    hashSet.add(movie);
                    holder.bg.setBackgroundColor(context.getResources().getColor(R.color.blackalpha));
                }
                return true;
            }
        });
    }

    public static ArrayList<CompanyInfo> getModels(){
            ArrayList<CompanyInfo> list = new ArrayList<>();
            for(CompanyInfo companyInfo : hashSet){
                list.add(companyInfo);
            }
            return list;
    }
    @Override
    public int getItemCount() {
        return companyInfoList.size();
    }


}


