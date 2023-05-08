package com.example.user.ok;


import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Connectionclass {
    String c= "com.mysql.jdbc.Driver";
    String url="jdbc:mysql://192.168.43.188:3306/2016bcs018";
    String user="root";
    String pass="root";
     public Connection CONN(){
        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn=null;
        String connURL=null;
        try {
            Class.forName(c);
            conn=DriverManager.getConnection(url,user,pass);
            conn=DriverManager.getConnection(connURL);
        } catch(ClassNotFoundException e){
            Log.e("ERRO",e.getMessage());



        }
        catch (SQLException se){
            Log.e("ERRO",se.getMessage());

        }



        catch (Exception e){
            Log.e("ERRO",e.getMessage());

        }


        return conn;
    }
}

