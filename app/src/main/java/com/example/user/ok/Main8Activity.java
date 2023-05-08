package com.example.user.ok;

//package com.example.user.jl;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.user.po.R;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
public class Main8Activity extends AppCompatActivity {

    public static final String Extra_Text=" com.example.user.ok.Extra_Text";
    public static final String Extra_field=" com.example.user.ok.Extra_field";
    public static final String Extra_Data=" com.example.user.ok.Extra_Data";
    public static final String Extra_cost=" com.example.user.ok.Extra_cost";

    EditText name;
    EditText phone;
    EditText toy,email,branch,Date,quantity,cost;
    Button reg;
    Connectionclass Connectionclass;
    String Z="";
    int c=0;
    String fg,p,n,dd,kj,e;
    int qua,cos,toc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Powerbank Section");
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        branch=(EditText)findViewById(R.id.editText5);
        Date=(EditText)findViewById(R.id.editText4);
        quantity=(EditText)findViewById(R.id.editText6);
        cost=(EditText)findViewById(R.id.editText7);
        toy=(EditText)findViewById(R.id.editText9);

        reg = (Button) findViewById(R.id.button7);
        Connectionclass = new Connectionclass();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doregister doregister;
                doregister = new Doregister();
                doregister.execute("");

                //public void mech(){


            }
        });
    }


    public class Doregister extends AsyncTask<String, String, String> {
        int m=10000;
        String Z = "";
        //boolean isSuccess = false;

        protected void onPreExecute() {

        }

        @Override
        protected String doInBackground(String... strings) {
            if (name.length()==0||phone.length() == 0 || email.length() == 0 || branch.length() == 0 || Date.length() == 0 || cost.length() == 0 || quantity.length() == 0||toy.length()==0) {
                Z = "Fill All The Entries";
            }
            else {

                n = name.getText().toString();
                p = phone.getText().toString();
                e = email.getText().toString();
                String b = branch.getText().toString();
                dd = Date.getText().toString();
                cos = Integer.parseInt(cost.getText().toString());
                qua = Integer.parseInt(quantity.getText().toString());
                toc=Integer.parseInt(toy.getText().toString());
                try {
                    Connection con = Connectionclass.CONN();
                    if (con == null) {
                        Z = "problem";
                    } else {
                        c++;
                        String q = "insert into powerbank_orders values(?,?,?,?,?,?,?,?)";
                        // Statement stmt =con.createStatement();
                        PreparedStatement ps = con.prepareStatement(q);
                        ps.setString(1, n);
                        ps.setString(2, p);
                        ps.setString(3, e);
                        ps.setString(4, b);
                        ps.setString(5, dd);
                        ps.setInt(6, qua);
                        ps.setInt(7, cos);
                        ps.setInt(8,toc);
                        int i = ps.executeUpdate();

                        Z = "registration is succesful";

                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

            }
            return Z;
        }

        protected void onPostExecute(String s){
            if(c==1) {

                Toast.makeText(getBaseContext(), "success" , Toast.LENGTH_LONG).show();
                mech();

            }

            //Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            //intent.putExtra(Z, Extra_Text);
            //intent.putExtra(n, Extra_field);
            //     startActivity(intent);
            else{
                Toast.makeText(getBaseContext(), "" + Z, Toast.LENGTH_LONG).show();

            }
        }
    }

    private void mech() {
        Toast.makeText(getBaseContext(), "Success" + Z, Toast.LENGTH_LONG).show();
        n = name.getText().toString();
        p = phone.getText().toString();
        //e = email.getText().toString();
        dd=Date.getText().toString();
        cos=Integer.parseInt(cost.getText().toString());
        Intent intent = new Intent(Main8Activity.this, Main13Activity.class);
        intent.putExtra(Extra_Text,n);
        intent.putExtra(Extra_Data,p);
        intent.putExtra(Extra_field,dd);
        intent.putExtra(Extra_cost,cos);
        startActivity(intent);

    }
}
