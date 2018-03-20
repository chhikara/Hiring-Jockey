package com.ssaxena36.quizzer;

/**
 * Created by ssaxena36 on 20/3/18.
 */
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by cic on 15/3/18.
 */



public class ConnectionClass
{
    // Change below settings as per your database ip and credentials
    String ip = "206.183.110.93"; // if you have to add port then it would be like .i.e. 182.50.133.109:1433
    String sn = "zerodefect.in"; // Server Name
    String db = "z0002"; //Name of Database
    String un = "umadb"; //Database user
    String password = "zpayonline"; //Database Password
    @SuppressLint("NewApi")
    public Connection CONN()
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            // ConnURL = "jdbc:jtds:sqlserver://" + sn + ";" + "databaseName=" + db + ";user=" + un + ";password=" + password + ";";

            //ConnURL = "jdbc:jtds:sqlserver://zerodefect.in;database=z0002;user=umadb;password=zpayonline";

            ConnURL = "jdbc:jtds:sqlserver://sql5030.site4now.net;database=DB_A353CC_user;User=DB_A353CC_user_admin;password=Pappukr@4444";

            //ConnURL = "jdbc:jtds:sqlserver://zerodefect.in;database=z0002;user=umadb;password=zpayonline";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}


