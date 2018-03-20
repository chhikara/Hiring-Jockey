package com.ssaxena36.quizzer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ssaxena36.quizzer.customfonts.MyRegularText;
import com.ssaxena36.quizzer.customfonts.MyTextView;
import com.ssaxena36.quizzer.util.DialogAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dmax.dialog.SpotsDialog;

public class LoginActivity extends AppCompatActivity {


    private TextView signup;
    private TextView signin;
    //private TextView fb, fbUp;
    private TextView account, accountUp;
    private EditText email, emailUp;
    private EditText password, passwordUp, fullUp;
    private MyTextView ima, imaUp;
    private AppCompatImageView dropper, dropperUp;
    private LinearLayout in, up;
    private String type = null;
    private int current = 0; // 0 for sign in and 1 for sign up
  //  public static String email,password;
    private ConnectionClass connectionClass;
    private MyRegularText signInButton;
    private AppCompatTextView signUpButton;
    // Declaring connection variables
    Connection con,connn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectionClass = new ConnectionClass();
        signup = findViewById(R.id.signup);
        signin = findViewById(R.id.signin);
        in = findViewById(R.id.signinpanel);
        up = findViewById(R.id.signuppanel);
        signInButton = findViewById(R.id.buttonsignin);
        signUpButton = findViewById(R.id.accountup);
        account = findViewById(R.id.account);
        email = findViewById(R.id.email);
        emailUp = findViewById(R.id.emailup);
        passwordUp = findViewById(R.id.passwordup);
        fullUp = findViewById(R.id.userup);
        ima = findViewById(R.id.ima);
        imaUp = findViewById(R.id.imaup);
        dropperUp = findViewById(R.id.chooseup);
        dropper = findViewById(R.id.choose);
        password = findViewById(R.id.password);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current != 1) {
//                    up.setVisibility(View.VISIBLE);
//                    in.setVisibility(View.GONE);
                    current = 1;
                    in.clearAnimation();
                    up.clearAnimation();
                    in.animate()
                            //.translationY(in.getHeight())
                            .alpha(0.0f)
                            .setDuration(300)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    in.setVisibility(View.GONE);
                                    up.setVisibility(View.VISIBLE);
                                    in.setAlpha(1.0f);
                       //             ((ValueAnimator)animation).reverse();
  //                                  animation.end();
                                }
                            });
                    signin.setTextColor(getResources().getColor(R.color.white));
                    signup.setTextColor(getResources().getColor(R.color.buttonColor));
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(current != 0) {
                    current = 0;
                    in.clearAnimation();
                    up.clearAnimation();
                    up.animate()
                          //  .translationY(up.getHeight())
                            .alpha(0.0f)
                            .setDuration(300)
                            .setListener(new AnimatorListenerAdapter() {
                                @Override
                                public void onAnimationEnd(Animator animation) {
                                    super.onAnimationEnd(animation);
                                    up.setVisibility(View.GONE);
                                    in.setVisibility(View.VISIBLE);
                                    up.setAlpha(1.0f);
                                    //up.animate().translationY(-up.getHeight());
                                   //     ((ValueAnimator) animation).reverse();
//                                        animation.end();
                                }
                            });
                    signup.setTextColor(getResources().getColor(R.color.white));
                    signin.setTextColor(getResources().getColor(R.color.buttonColor));
                }
            }
        });
        final String ops[] = {"Recruiter", "Candidate"};
        final DialogAdapter gen = new DialogAdapter(this, ops);
        dropper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(
                        LoginActivity.this);
                builderSingle.setAdapter(gen,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which)
                                {
                                    case 0:
                                        type = ops[0];
                                        ima.setText(Html.fromHtml("I am a? <b>"+ops[0]+"</b>!"));
                                        break;
                                    case 1: // delete
                                        type = ops[1];
                                        ima.setText(Html.fromHtml("I am a? <b>"+ops[1]+"</b>!"));
                                        break;
                                }
                                dialog.dismiss();
                            }
                        });
                builderSingle.create();
                builderSingle.show();
            }
        });
        dropperUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(
                        LoginActivity.this);
                builderSingle.setAdapter(gen,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which)
                                {
                                    case 0:
                                        type = ops[0];
                                        imaUp.setText(Html.fromHtml("I am a? <b>"+ops[0]+"</b>!"));
                                        break;
                                    case 1: // delete
                                        type = ops[1];
                                        imaUp.setText(Html.fromHtml("I am a? <b>"+ops[1]+"</b>!"));
                                        break;
                                }
                                dialog.dismiss();
                            }
                        });
                builderSingle.create();
                builderSingle.show();
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = 1;
                in.clearAnimation();
                up.clearAnimation();
                in.animate()
                        //.translationY(in.getHeight())
                        .alpha(0.0f)
                        .setDuration(300)
                        .setListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                in.setVisibility(View.GONE);
                                up.setVisibility(View.VISIBLE);
                                in.setAlpha(1.0f);
                                //             ((ValueAnimator)animation).reverse();
                                //                                  animation.end();
                            }
                        });
                signin.setTextColor(getResources().getColor(R.color.white));
                signup.setTextColor(getResources().getColor(R.color.buttonColor));
            }
        });
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // email, password, rec/cand
                String emailText = email.getText().toString();
                String passwordText = password.getText().toString();
                if(!(emailText.isEmpty() || passwordText.isEmpty() || type == null)){
                    SignIn signIn = new SignIn(LoginActivity.this, emailText, passwordText, type);
                    signIn.execute();
                }
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // email. passowkrd, fullname
                String emailText = emailUp.getText().toString();
                String passwordText = passwordUp.getText().toString();
                String fullText = fullUp.getText().toString();
                if(!(emailText.isEmpty() || passwordText.isEmpty() || type == null || fullText.isEmpty())){
                    SignUp signUp = new SignUp(LoginActivity.this, emailText, fullText, passwordText, type);
                    signUp.execute();
                }
            }
        });
    }
    class SignIn extends AsyncTask<Void, Void, Boolean> {
        String email, password, type;
        SpotsDialog dialog;
        Context context;
        public SignIn(Context context, String email, String password, String type){
            this.email = email;
            this.password = password;
            this.type = type;
            this.context = context;
            dialog = new SpotsDialog(context, R.style.Custom);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            con = connectionClass.CONN();
            if (con == null) {
                return Boolean.FALSE;
            } else {
                String query;
                if(type.compareTo("Recruiter") == 0){
                    query = "SELECT * from RecruitData WHERE email='" + email + "'"+" AND password='" + password+"';";
                } else
                query = "SELECT * from UserData WHERE email='" + email + "'"+" AND password='" + password+"';";
                Log.e("query", query);
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        if(type.compareTo("Recruiter") == 0){
                            editor.putString("name", rs.getString(1));
                            editor.putString("place", rs.getString(2));
                            editor.putString("domain", rs.getString(3));
                            editor.putString("exp", rs.getString(4));
                            editor.putString("ctc", rs.getString(5));
                            editor.putString("details", rs.getString(6));
                            editor.putString("website", rs.getString(7));
                            editor.putString("phone", rs.getString(8));
                            editor.putString("contact", rs.getString(9));
                            editor.putString("email", rs.getString(10));
                            editor.putString("password", rs.getString(11));
                            editor.apply();
                        } else {
                            editor.putString("email", rs.getString(1));
                            editor.putString("password", rs.getString(2));
                            editor.putString("fullname", rs.getString(3));
                            editor.putString("city", rs.getString(4));
                            editor.putString("state", rs.getString(5));
                            editor.putString("sex", rs.getString(6));
                            editor.putString("birthday", rs.getString(7));
                            editor.putString("resumeurl", rs.getString(8));
                            editor.putString("githubprofile", rs.getString(9));
                            editor.putString("matriculationscore", rs.getString(10));
                            editor.putString("intermediatescore", rs.getString(11));
                            editor.putString("graduationscore", rs.getString(12));
                            editor.putString("experience", rs.getString(13));
                            editor.putString("certification", rs.getString(14));
                            editor.putString("aptitudetest", rs.getString(15));
                            editor.putString("project", rs.getString(16));
                            editor.putString("usertype", rs.getString(17));
                            editor.apply();
                        }
                        // todo success
                        con.close();
                        return Boolean.TRUE;
                    } else {
                        return Boolean.FALSE;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            }
        }
        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            if(aVoid) {
                Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                if (type.compareTo("Recruiter") == 0) {
                } else {
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
                }
            }
            dialog.dismiss();
        //    Toast.makeText(LoginActivity.this, String.valueOf(aVoid), Toast.LENGTH_SHORT).show();
        }
    }

    class SignUp extends AsyncTask<Void, Void, Boolean> {
        String email, password, type, fullName;
        SpotsDialog dialog;
        Context context;
        public SignUp(Context context, String email, String fullName, String password, String type){
            this.email = email;
            this.fullName = fullName;
            this.password = password;
            this.context = context;
            this.type = type;
            dialog = new SpotsDialog(context, R.style.Custom);
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }
        @Override
        protected Boolean doInBackground(Void... voids) {
            con = connectionClass.CONN();
            if (con == null) {
                return Boolean.FALSE;
            } else {
                String query;
                if(type.compareTo("Recruiter") == 0){
                    query = "INSERT INTO RecruitData(email, password, name) VALUES('" + email + "','" + password + "','" + fullName + "');";
                } else {
                    query = "INSERT INTO UserData(email, password, fullname, usertype) VALUES('" + email + "','" + password + "','" + fullName + "','" + type + "');";
                }Log.e("query", query);
                Statement stmt = null;
                try {
                    stmt = con.createStatement();
                    int res = stmt.executeUpdate(query);
                    Log.e("updated", String.valueOf(res));
                    /*if (rs.next()) {
                        // todo success
                        //fulName = rs.getString(3);
                        //subject = rs.getString(4);
                        con.close();
                        return Boolean.TRUE;
                    } else {
                        return Boolean.FALSE;
                    } */
                    return res == 1;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            }
        }
        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            if(aVoid){
                SharedPreferences.Editor editor = context.getSharedPreferences("mydata", MODE_PRIVATE).edit();

            }
            dialog.dismiss();
            Toast.makeText(LoginActivity.this, String.valueOf(aVoid), Toast.LENGTH_SHORT).show();
        }
    }
}
