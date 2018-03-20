package com.ssaxena36.quizzer;


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.ssaxena36.quizzer.customfonts.MyEditText;
import com.ssaxena36.quizzer.util.BlurBuilder;
import com.ssaxena36.quizzer.util.DialogAdapter;

import java.util.Calendar;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity{
    AppCompatTextView myname, myemail, myemail2, emailHeader, cityHeader, sexHeader, nameHeader, bdayHeader, stateHeader, myname2, mysex, mycity, mystate, resume, resumeHeader, git, gitHeader, tenth, tenthHeader, twelfth, twelfthHeader, grad, gradHeader, exp, expHeader, prjHeader, prj, certi, certiHeader, apti, aptiHeader;
    CircleImageView myphoto;
    private DialogAdapter gen;
    private static AppCompatTextView mybday;
    AppCompatImageView background;
    Typeface custom_font, head_font;
    SharedPreferences sharedPreferences;
    private HashMap<String, String> map = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sharedPreferences = getApplicationContext().getSharedPreferences("mydata", MODE_PRIVATE);
        head_font = Typeface.createFromAsset(getApplicationContext().getAssets(),  "fonts/Lato-Regular.ttf");
        custom_font = Typeface.createFromAsset(getApplicationContext().getAssets(),  "fonts/second.ttf");
        AppCompatTextView header = findViewById(R.id.barHeader);
        AppCompatTextView option = findViewById(R.id.options);
        header.setTypeface(head_font);
        header.setText("Profile Update");
        option.setVisibility(View.VISIBLE);
        option.setText("NEXT");
        option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //todo update from internet
                Intent intent = new Intent(ProfileActivity.this, CompanyActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                // overridePendingTransition(android.R.anim.fade_out, android.R.anim.fade_in);
            }
        });
        init();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.passport);
        Bitmap blurredBitmap = BlurBuilder.blur( this, originalBitmap );
        background.setImageDrawable(new BitmapDrawable(getResources(), blurredBitmap));
    }

    public void init(){
        emailHeader = findViewById(R.id.emailHeader);
        emailHeader.setText(Html.fromHtml("<b>Email</b>"));
        emailHeader.setTypeface(custom_font);
        myname = findViewById(R.id.myname);
        myname.setText(Html.fromHtml("<b>Shubham Saxena</b>"));
        myname.setTypeface(custom_font);
        myemail = findViewById(R.id.myemail);
        myemail2 = findViewById(R.id.myemail2);
        background = findViewById(R.id.background);
        cityHeader = findViewById(R.id.cityHeader);
        cityHeader.setText(Html.fromHtml("<b>City</b>"));
        cityHeader.setTypeface(custom_font);
        bdayHeader = findViewById(R.id.bdateHeader);
        bdayHeader.setText(Html.fromHtml("<b>Birth Date</b>"));
        bdayHeader.setTypeface(custom_font);
        sexHeader = findViewById(R.id.sexHeader);
        sexHeader.setText(Html.fromHtml("<b>Sex</b>"));
        sexHeader.setTypeface(custom_font);
        nameHeader = findViewById(R.id.nameHeader);
        nameHeader.setText(Html.fromHtml("<b>Name</b>"));
        nameHeader.setTypeface(custom_font);
        myemail2.setTypeface(custom_font);
        stateHeader = findViewById(R.id.stateHeader);
        stateHeader.setText(Html.fromHtml("<b>State</b>"));
        stateHeader.setTypeface(custom_font);
        mycity = findViewById(R.id.mycity);
        mycity.setTypeface(custom_font);
        mystate = findViewById(R.id.mystate);
        mystate.setTypeface(custom_font);
        mysex = findViewById(R.id.mysex);
        mysex.setTypeface(custom_font);
        myname2 = findViewById(R.id.myname2);
        myname2.setTypeface(custom_font);
        mybday = findViewById(R.id.mybday);
        mybday.setTypeface(custom_font);
        String ops[] = {"Male", "Female"};
        gen = new DialogAdapter(this, ops);
        resume = findViewById(R.id.resume);
        resume.setTypeface(custom_font);
        resumeHeader = findViewById(R.id.resumeHeader);
        resumeHeader.setText(Html.fromHtml("<b>Resume URL</b>"));
        resumeHeader.setTypeface(custom_font);
        gitHeader = findViewById(R.id.gitHeader);
        gitHeader.setText(Html.fromHtml("<b>GitHub Profile</b>"));
        gitHeader.setTypeface(custom_font);
        git = findViewById(R.id.git);
        git.setTypeface(custom_font);
        tenthHeader = findViewById(R.id.tenthHeader);
        tenthHeader.setText(Html.fromHtml("<b>Matriculation Score</b>"));
        tenthHeader.setTypeface(custom_font);
        tenth = findViewById(R.id.tenth);
        tenth.setTypeface(custom_font);
        twelfthHeader = findViewById(R.id.twelfthHeader);
        twelfthHeader.setText(Html.fromHtml("<b>Intermediate Score</b>"));
        twelfthHeader.setTypeface(custom_font);
        twelfth = findViewById(R.id.twelfth);
        twelfth.setTypeface(custom_font);
        gradHeader = findViewById(R.id.gradHeader);
        gradHeader.setText(Html.fromHtml("<b>Graduation Score</b>"));
        gradHeader.setTypeface(custom_font);
        grad = findViewById(R.id.grad);
        grad.setTypeface(custom_font);
        expHeader = findViewById(R.id.expHeader);
        expHeader.setText(Html.fromHtml("<b>Experience(in years)</b>"));
        expHeader.setTypeface(custom_font);
        exp = findViewById(R.id.exp);
        exp.setTypeface(custom_font);
        prjHeader = findViewById(R.id.projHeader);
        prjHeader.setText(Html.fromHtml("<b>Projects</b>"));
        prjHeader.setTypeface(custom_font);
        prj = findViewById(R.id.proj);
        prj.setTypeface(custom_font);
        aptiHeader = findViewById(R.id.aptiHeader);
        aptiHeader.setTypeface(custom_font);
        aptiHeader.setText(Html.fromHtml("<b>Aptitude Test Scores</b>"));
        apti = findViewById(R.id.apti);
        apti.setTypeface(custom_font);
        certiHeader = findViewById(R.id.certiHeader);
        certiHeader.setTypeface(custom_font);
        certiHeader.setText(Html.fromHtml("<b>Certifications</b>"));
        certi = findViewById(R.id.certi);
        certi.setTypeface(custom_font);
     //   autocompleteFragment = (PlaceAutocompleteFragment)
       //         getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
    }
   // PlaceAutocompleteFragment autocompleteFragment;
    public void mailer(View view) {
        /*final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.getemail, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.emaillDialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Email</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(ProfileActivity.this, "Empty Emai?", Toast.LENGTH_SHORT).show();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        }); */
    }

    public void fullName(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.getname, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.nameDialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Name</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(ProfileActivity.this, "Empty Name?", Toast.LENGTH_SHORT).show();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               alertDialog.dismiss();
            }
        });
    }

    public void cityChanger(View view) {
       /* final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.getcity, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.cityDialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your City</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    Toast.makeText(ProfileActivity.this, "Empty City?", Toast.LENGTH_SHORT).show();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        }); */
      //  final AppCompatEditText edittext = new AppCompatEditText(this);
       // alert.setMessage("Enter Your Message");
        //alert.setTitle("Enter Your Title");
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException|GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
        /*autocompleteFragment.setMenuVisibility(true);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
              //  Log.i(TAG, "Place: " + place.getName());
                Toast.makeText(ProfileActivity.this, place.getName().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Toast.makeText(ProfileActivity.this, status.toString(), Toast.LENGTH_SHORT).show();
                //Log.i(TAG, "An error occurred: " + status);
            }
        }); */

    }

    public void sexChanger(View view) {
        android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(
 this);
        builderSingle.setAdapter(gen,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which)
                        {
                            case 0:
                                break;
                            case 1: // delete
                                break;
                            case 2: //details
                                break;
                        }
                        dialog.dismiss();
                    }
                });
        builderSingle.create();
        builderSingle.show();
    }

    public void bdateChanger(View view) {
        new DatePickerFragment().show(getSupportFragmentManager(), "datePicker");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PLACE_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                Place place = PlacePicker.getPlace(this, data);
              /*  Geocoder geocoder = new Geocoder(this);
                try
                {
                    List<Address> addresses = geocoder.getFromLocation(place.getLatLng().latitude,place.getLatLng().longitude, 1);
                    //String address = addresses.get(0).getAddressLine(0);
                    //String city = addresses.get(0).getAddressLine(1);
                    //String state = addresses.get(0).getAddressLine(2);
                    Toast.makeText(this, addresses.get(0).toString(), Toast.LENGTH_SHORT).show();
                    //String country = addresses.get(0).getAddressLine(2);

                } catch (IOException e)
                {
                 //   bottomSheetAddress.setText("Not Available.");
                    e.printStackTrace();
                } */
                String toastMsg = String.format("Place: %s", place.getName());
                Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
            }
        }
    }
    int PLACE_PICKER_REQUEST = 1;
    public void stateChanger(View view) throws GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);
    }

    public void resumeAdder(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Resume URL</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
   //     editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("http://www.google.com/resume");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void gitChanger(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Github URL</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
    //    editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("http://github.com/shubh3695");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void matricChanger(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Matriculation Score</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
 //       editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("9.5 CGPA or 95%");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void intermediateChanger(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Intermediate Score</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
   //     editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("9.5 CGPA or 95%");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void gradScore(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Graduation Score</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
      //  editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("9.5 CGPA or 95%");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void expChanger(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Professional Experience</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText.setHint("2");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void certiChanger(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Certifications</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
   //     editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("1. Data Structures\n2. Machine Learning");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void aptiChanger(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Aptitude Scores</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
       // editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("1. AMCAT : 199\n2. GRE : 342");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public void projChanger(View view) {

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        View view1 = getLayoutInflater().inflate(R.layout.onlytextdialog, null);
        alert.setView(view1);
        final AlertDialog alertDialog = alert.show();
        AppCompatTextView header = view1.findViewById(R.id.dialogHeader);
        header.setTypeface(custom_font);
        header.setText(Html.fromHtml("<b>Enter your Projects</b>"));
        AppCompatTextView ok = view1.findViewById(R.id.done);
        ok.setTypeface(custom_font);
        AppCompatTextView cancel = view1.findViewById(R.id.cancel);
        cancel.setTypeface(custom_font);
        final MyEditText editText = view1.findViewById(R.id.text_layout);
//        editText.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
        editText.setHint("1. Slack Chat Bot using Python.");
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ProfileActivity.this, editText.getText().toString(), Toast.LENGTH_SHORT).show();
                if(editText.getText().toString().isEmpty()){
                    alertDialog.dismiss();
                } else alertDialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
            }
        });
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {
        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_LIGHT, this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            String date = String.valueOf(day)+"/"+String.valueOf(month)+"/"+String.valueOf(year);
            mybday.setText(date);
        }
    }
}
