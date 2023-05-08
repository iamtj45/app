package com.example.user.ok;


import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
//import  android.app. ActionBar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    public static final String Extra_Tt=" com.example.user.ok.Extra_Tt";

    EditText i,t;
    Button b,ne,a;
    int n;
    String o;
    String Z="";
    String s;
    Connectionclass Connectionclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Main Screen");
        i = (EditText) findViewById(R.id.editText2);
        t=(EditText)findViewById(R.id.editText);
        b = (Button) findViewById(R.id.button);
        ne=(Button)findViewById(R.id.button2);
        a=(Button)findViewById(R.id.button3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                o=i.getText().toString();
                s=t.getText().toString();
                //String x=P.getText().toString();

                Dolog doregister;
                doregister = new Dolog();
                doregister.execute("");
            }
        });

        ne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Main3Activity.class);
                //  i.putExtra(Extra_Tt,o);
                startActivity(i);

            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o=new Intent(MainActivity.this,Main4Activity.class);
                startActivity(o);
            }
        });

        Connectionclass=new Connectionclass();
    }

    public class Dolog extends AsyncTask<String, String, String> {
        // int l;
        //Boolean isSucess = false;

        String p=o;
        String v=s;
        // String x=P.getText().toString();

        //Connectionclass =new Connectionclass();
        @Override
        protected String doInBackground(String... strings) {
            if (i.length()==0||t.length() == 0 ) {
                Z = "Fill All The Entries";
            }
            else {

                try {
                    Connection con = Connectionclass.CONN();
                    if (con == null) {

                        Z = "problem connection ";

                    } else {
                        //   Intent im=new Intent(MainActivity.this,Main6Activity.class);
                        // im.putExtra(Extra_Tt,o);
                        //startActivity(im);


                        String q = "select * from client where Email='" + v + "' and ID='" + p + "' ";
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery(q);
                        if (rs.next()) {
                            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                            Bundle bundle=new Bundle();
                            bundle.putString("key_1",p);
                            intent.putExtras(bundle);
                            startActivity(intent);
                            Z = "valid";
                        } else {

                            Z = "invalid";
                            // isSucess = false;

                        }

                    }
                    con.close();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }            //   l=c;
            return Z;
        }

        protected void onPostExecute(String r) {
//if(l==1) {
            //  }
            // if(l==1) {
            if(Z.equalsIgnoreCase("valid")){
                Toast.makeText(MainActivity.this, "  Login is  " + Z, Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                Bundle bundle=new Bundle();
                bundle.putString("key_1",p);
                intent.putExtras(bundle);
                startActivity(intent);










                //Intent i=new Intent(youtub.this,Main5Activity.class);

                //i.putExtras(extras);
                //startActivity(i);




            }
            else if(Z.equalsIgnoreCase("invalid")){

                Toast.makeText(MainActivity.this, "Login is " + Z, Toast.LENGTH_LONG).show();
            }
            else {

                Toast.makeText(MainActivity.this, "problem" + Z, Toast.LENGTH_LONG).show();
            }
            //  mech();
            //}
            //else{
            //  Toast.makeText(MainActivity.this,"Problem Invalid User ",Toast.LENGTH_LONG).show();
            // }
    /*if (isSucess) {
                Toast.makeText(MainActivity.this,"Success",Toast.LENGTH_LONG).show();
            }*/
        }

    }

    //private void mech() { //n = name.getText().toString();

    //Intent intent = new Intent(MainActivity.this, Main2Activity.class);
    //intent.putExtra( Extra_Text,n);
    //intent.putExtra(n, Extra_field);
    //startActivity(intent);

    //}
    //class show {

    //  void check(){

    //    Toast.makeText(MainActivity.this,"In the Loop",Toast.LENGTH_LONG).show();

    //}
}




