package com.example.user.ok;

//package com.example.user.jl;
//package com.example.user.app;

//package com.example.user.po;

import android.content.Intent;
import android.os.AsyncTask;
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
public class Main3Activity extends AppCompatActivity {
    public static final String Extra_Text=" com.example.user.ok.Extra_Text";
    public static final String Extra_field=" com.example.user.ok.Extra_field";
    public static final String Extra_Data=" com.example.user.ok.Extra_Data";

    EditText name,cob;
    EditText phone,em;
    EditText email,branch,Date;
    Button reg;
    Connectionclass Connectionclass;
    String Z="";
    int c=0;
    String fg,p,n,dd,kj,e;
    int xs,xc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = (EditText) findViewById(R.id.editText);
        phone = (EditText) findViewById(R.id.editText2);
        email = (EditText) findViewById(R.id.editText3);
        branch=(EditText)findViewById(R.id.editText4);
        Date=(EditText)findViewById(R.id.editText5);
        em=(EditText)findViewById(R.id.editText7);
        cob=(EditText)findViewById(R.id.editText8);
        reg = (Button) findViewById(R.id.button);
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
            n = name.getText().toString();
            p = phone.getText().toString();
            e = email.getText().toString();
            String b = branch.getText().toString();
            dd=Date.getText().toString();
            xc=Integer.parseInt(em.getText().toString());
            xs=Integer.parseInt(cob.getText().toString());
            try {
                Connection con = Connectionclass.CONN();
                if (con == null) {
                    Z = "problem";
                } else {
                    c++;
                    String q = "insert into client values(?,?,?,?,?,?,?)";
                    // Statement stmt =con.createStatement();
                    PreparedStatement ps=con.prepareStatement(q);
                    ps.setString(1,n);
                    ps.setString(2,p);
                    ps.setString(3,e);
                    ps.setString(4,dd);
                    ps.setString(5,b);
                    ps.setInt(6,xc);
                    ps.setInt(7,xs);
                    int i=ps.executeUpdate();

                    Z = "registration is succesful";

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
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
        // Toast.makeText(getBaseContext(), "Successful registration completed" + Z, Toast.LENGTH_LONG).show();
        Toast.makeText(getBaseContext(), "Successful registration completed ,Make sure about your Registration By  doing Login with username and id" + Z, Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Main3Activity.this, MainActivity.class);

        startActivity(intent);

    }
}

