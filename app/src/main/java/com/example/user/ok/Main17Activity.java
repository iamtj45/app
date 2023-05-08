package com.example.user.ok;
//package com.example.user.jl;

import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main17Activity extends AppCompatActivity {
    EditText Ua, PA;
    TextView nae,ad,ci,em,mem,cob;
    String sx, na,add,cii,emm,meme,col;
    int  da,ic;
    int c = 0;
    String Z = "";
    Button h;
    Connectionclass Connectionclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(" ");
        nae = (TextView) findViewById(R.id.textView14);
        ad = (TextView) findViewById(R.id.textView15);
        ci = (TextView) findViewById(R.id.textView16);
        em = (TextView) findViewById(R.id.textView17);
        mem = (TextView) findViewById(R.id.textView18);
        cob = (TextView) findViewById(R.id.textView19);



        Ua = (EditText) findViewById(R.id.editText6);
        h = (Button) findViewById(R.id.button4);
        Connectionclass = new Connectionclass();

        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doregister doregister;
                doregister = new Doregister();
                doregister.execute("");

            }
        });

    }

    public class Doregister extends AsyncTask <String, String, String> {

        protected String doInBackground(String... strings) {
            //    String Z = null;
            // String sa=zx.setText((CharSequence)qa);
            sx=Ua.getText().toString();
            //ws=PA.getText().toString();
//zx.setText(set);


            try {
                Connection con = Connectionclass.CONN();
                if (con == null) {
                    Z= "problem";

                } else {
                    Statement st=con.createStatement();
                    ResultSet rs =st.executeQuery("select * from client where ID='"+sx+"'");


                    //tring q = "select * from  ab where mobile='+set+'";
                    // Statement stmt =con.createStatement();
                    // PreparedStatement ps=con.prepareStatement(q);
                    //ResultSet rs=ps.executeQuery();
                    //ps.setString(1,n);
                    //ps.setString(2,p);
                    //ps.setString(3,e);
                    if(rs.next()) {
//c=1;
                        //    Z = "registration is succesful";
                        //while (rs.next()) {
//                        g = rs.getString(1);
                        na=rs.getString(1);
                        add=rs.getString(3);
                        cii=rs.getString(4);
                        emm=rs.getString(5);
                        meme=rs.getString(6);
                        col=rs.getString(7);

                        c++;
                        //if(set.equalsIgnoreCase(g)&&ws.equalsIgnoreCase(x)){
                        //  mech();
                        //c++;

//                        }
                        // mech();
                        //                      n=c;
                    }
                }
            } catch (SQLException e1) {
//                isSuccess=false;
                e1.printStackTrace();
            }

            //return Z;

            return Z;
        }
        protected void onPostExecute(String s){
            mech();
            if(c==1) {
                mech();
                Toast.makeText(getBaseContext(), "" + Z, Toast.LENGTH_LONG).show();
            }
            //else {
            //  mech();
            //}//intent.putExtra(n,Extra_field);
            //  zx.setText(Z);

            //      Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            //              intent.putExtra(Z, Extra_Text);
            //    startActivity(intent);

        }
        private void mech() {
            //for(int i=0;i<n;i++) {
            nae.setText("Name of client "+na);
            //zc.setText(" "+fx);
            ad.setText("Having Address "+add);
            ci.setText("Living At "+cii);
            em.setText("Mail_Id "+emm);
            mem.setText("Having Membership "+meme);
            cob.setText("Contact_Number" +col);



        }



    }





}
