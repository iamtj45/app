package com.example.user.ok;

//package com.example.user.jl;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main14Activity extends AppCompatActivity {
    Button x;
    TextView d,p,e;
    String name,pro,da;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(" ");
        x=(Button)findViewById(R.id.button3);
        d=(TextView)findViewById(R.id.textView6);
        p=(TextView)findViewById(R.id.textView7);
        e=(TextView)findViewById(R.id.textView8);
        Intent intent=getIntent();
        name=intent.getStringExtra(Main9Activity.Extra_Text);
        pro=intent.getStringExtra(Main9Activity.Extra_Data);
        da=intent.getStringExtra(Main9Activity.Extra_field);
        d.setText("Customer Having Id "+name);
        p.setText("Ordered "+pro);
        e.setText("On Date "+da);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main14Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
