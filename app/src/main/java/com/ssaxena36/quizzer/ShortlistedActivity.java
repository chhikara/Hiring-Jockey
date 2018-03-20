package com.ssaxena36.quizzer;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.ssaxena36.quizzer.util.CompanyInfo;
import com.ssaxena36.quizzer.util.CompanyModel;
import com.ssaxena36.quizzer.util.ShortlistedAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import me.rishabhkhanna.recyclerswipedrag.OnDragListener;
import me.rishabhkhanna.recyclerswipedrag.OnSwipeListener;
import me.rishabhkhanna.recyclerswipedrag.RecyclerHelper;

/**
 * Created by ssaxena36 on 20/3/18.
 */

public class ShortlistedActivity extends AppCompatActivity
{
    private View none;
    private Typeface custom_font, det_font;
    ArrayList<CompanyInfo> list = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutlist);
        custom_font = Typeface.createFromAsset(getAssets(), "fonts/Lato-Regular.ttf");
        det_font = Typeface.createFromAsset(getAssets(), "fonts/second.ttf");
        none = findViewById(R.id.no_selections);
        ((AppCompatTextView) findViewById(R.id.texter)).setTypeface(det_font);
        Toolbar toolbar = findViewById(R.id.toolbar);
        //toolbar.setNavigationIcon(R.drawable.returner);
        AppCompatTextView title = toolbar.findViewById(R.id.barHeader);
        title.setText("Priority Alignment");
        title.setTypeface(custom_font);
        AppCompatImageView backer = toolbar.findViewById(R.id.ret);
        AppCompatTextView submit = toolbar.findViewById(R.id.options);
        submit.setText("SUBMIT");
        backer.setVisibility(View.VISIBLE);
        backer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        submit.setTypeface(Typeface.DEFAULT_BOLD);
        submit.setVisibility(View.VISIBLE);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(ShortlistedActivity.this);
                View view1 = getLayoutInflater().inflate(R.layout.dialog_complete, null);
                alert.setView(view1);
                final AlertDialog alertDialog = alert.show();
                AppCompatImageView tick = view1.findViewById(R.id.imageView);
                AppCompatTextView det = view1.findViewById(R.id.detail);
                AppCompatTextView detHeader = view1.findViewById(R.id.detailHeader);
                AppCompatButton button = view1.findViewById(R.id.ok);
                detHeader.setTypeface(det_font);
                detHeader.setText(Html.fromHtml("<b>Success</b>"));
                ((Animatable)tick.getDrawable()).start();
                det.setTypeface(det_font);
                alertDialog.setCanceledOnTouchOutside(false);
                alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface) {
                        //todo redirect to home.
                        Toast.makeText(ShortlistedActivity.this, "Dismiss.", Toast.LENGTH_SHORT).show();
                    }
                });
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // todo redirect to home.
                        alertDialog.dismiss();
                    }
                });
            }
        });
        list = CompanyActivity.companyInfos;
        for(CompanyInfo companyInfo : list){
            Log.d("info", companyInfo.getAddress()+" "+companyInfo.getPrice());
        }
       //ImageView mImgCheck = findViewById(R.id.imageView);
       // ((Animatable) mImgCheck.getDrawable()).start();
        RecyclerView.Adapter adapterAdapter = new ShortlistedAdapter(this, list);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapterAdapter);
        //      Library addition from here
        RecyclerHelper touchHelper = new RecyclerHelper(list, adapterAdapter);
        touchHelper.setRecyclerItemDragEnabled(true).setOnDragItemListener(new OnDragListener() {
            @Override
            public void onDragItemListener(int fromPosition, int toPosition) {
                Log.d("Something", "onDragItemListener: callback after dragging recycler view item");
            }
        });
        touchHelper.setRecyclerItemSwipeEnabled(true).setOnSwipeItemListener(new OnSwipeListener() {
            @Override
            public void onSwipeItemListener() {
                Log.d("Something", "onSwipeItemListener: callback after swiping recycler view item");
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(touchHelper);
        itemTouchHelper.attachToRecyclerView(recyclerView);
        if(list.isEmpty()){
            none.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            submit.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }
}
