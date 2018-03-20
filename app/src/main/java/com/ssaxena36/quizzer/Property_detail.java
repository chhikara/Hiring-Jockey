package com.ssaxena36.quizzer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ssaxena36 on 20/3/18.
 */

public class Property_detail extends AppCompatActivity {
    private TextView price, address, bed, bath, sqft;
    private ImageView imagev;
    private String strprice, straddress, strbed, strbath, strsqft, strimage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propertydetail);
        Intent i = getIntent();
        strprice = i.getStringExtra("price");
        straddress = i.getStringExtra("address");
        strbath = i.getStringExtra("bath");
        strbed = i.getStringExtra("bed");
        strsqft = i.getStringExtra("sqft");
        strimage = i.getStringExtra("image");
        price =  findViewById(R.id.tvprice);
        address =  findViewById(R.id.tvaddress);
        bath =  findViewById(R.id.tvshower);
        bed = findViewById(R.id.tvbed);
        sqft = findViewById(R.id.tvsqft);
        imagev = findViewById(R.id.imagev);
        price.setText(strprice);
        address.setText(straddress);
        bed.setText(strbed);
        bath.setText(strbath);
        sqft.setText(strsqft);
        findViewById(R.id.gotoplace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+strprice+","+straddress);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        findViewById(R.id.gotoplacer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q="+strprice+","+straddress);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        findViewById(R.id.call).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "+91-8765513361";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });
        findViewById(R.id.email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"shubh3695@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Query/ Help");
                i.putExtra(Intent.EXTRA_TEXT   , "Help Required");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(Property_detail.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        findViewById(R.id.myTextView_Roboto_Regular).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "http://www.glassdoor.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });
    }
}
