package com.example.user.ok;

//package com.example.user.jl;


import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button l,r,a;
    EditText u,p;
    String us,pa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        ActionBar ab=getSupportActionBar();
        ab.setTitle("Admin Login");

        u=(EditText)findViewById(R.id.editText);
        p=(EditText)findViewById(R.id.editText2);
        l=(Button)findViewById(R.id.button);
        r=(Button)findViewById(R.id.button10);
        //a=(Button)findViewById(R.id.button3);
        // us=u.getText().toString();
        //pa=p.getText().toString();
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                us=u.getText().toString();
                pa=p.getText().toString();
                if (u.length()==0||p.length() == 0 ) {
                    u.setError("fill username");
                    p.setError("fill password");
                    // Z = "Entries";
                }
                else {

                    if (us.equalsIgnoreCase("admin") && pa.equalsIgnoreCase("admin")) {
                        Intent intent = new Intent(Main4Activity.this, Main5Activity.class);
                        startActivity(intent);

                    } else {
                        Toast.makeText(Main4Activity.this, "Error", Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jh=new Intent(Main4Activity.this,MainActivity.class );
                startActivity(jh);
            }
        });

    }
}
