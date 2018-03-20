package com.ssaxena36.quizzer;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.ssaxena36.quizzer.util.CompanyInfo;
import java.util.ArrayList;

import static com.ssaxena36.quizzer.RecycleAdapter_propertylist.getModels;

/**
 * Created by ssaxena36 on 20/3/18.
 */

public class CompanyActivity extends AppCompatActivity {

    private Typeface custom_font;
    private String address[]= {"India, Pune","India, Bangalore","India, Kolkatta","India, Gurgaon"};
    private String bed[]= {"IT","BPO","IT","IT/BPO"};
    private String shower[]= {"2-3y","0-2y","Freshers Only" ,"2 y"};
    private String sqft[]= {"4.5lpa","3.5lpa","NA","5-6lpa"};
    private String price[]= {"Google","Informatica","SpaceX","The Boring Company"};
    private int image[]= {R.drawable.buildingone,R.drawable.buidingtwo,R.drawable.buildingthree,R.drawable.outdoorgames};

    private ArrayList<CompanyInfo> companyInfoArrayList;
    private RecyclerView recyclerView;
    private RecycleAdapter_propertylist mAdapter;
    static ArrayList<CompanyInfo> companyInfos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.companyview);
        custom_font = Typeface.createFromAsset(getApplicationContext().getAssets(),  "fonts/Lato-Regular.ttf");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppCompatTextView title = toolbar.findViewById(R.id.barHeader);
        AppCompatImageView ret = toolbar.findViewById(R.id.ret);
        ret.setVisibility(View.VISIBLE);
        ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        title.setText("Select Companies");
        title.setTypeface(custom_font);
        AppCompatTextView next = toolbar.findViewById(R.id.options);
        next.setText("NEXT");
        next.setVisibility(View.VISIBLE);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              companyInfos = getModels();
                Intent mIntent = new Intent(CompanyActivity.this, ShortlistedActivity.class);
                startActivity(mIntent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
            }
        });
        recyclerView = findViewById(R.id.recyclerview_property);
        companyInfoArrayList = new ArrayList<>();
        for (int i = 0; i < address.length; i++) {
            CompanyInfo beanClassForRecyclerView_contacts = new CompanyInfo(address[i],price[i],bed[i],shower[i],sqft[i],image[i]);
            companyInfoArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new RecycleAdapter_propertylist(this, companyInfoArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
