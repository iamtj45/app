package com.example.user.ok;
//package com.example.user.jl;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main5Activity extends AppCompatActivity {
    Button lo,s,d,se;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ActionBar ab=getSupportActionBar();
        ab.setTitle(" ");

        //s=(Button)findViewById(R.id.button5);
        d=(Button)findViewById(R.id.button6);
        se=(Button)findViewById(R.id.button8);
        lo=(Button)findViewById(R.id.button9);
        // s.setOnClickListener(new View.OnClickListener() {
        //@Override
        //   public void onClick(View v) {
        //Intent gc=new Intent(Main5Activity.this,Main15Activity.class);
        //startActivity(gc);
        //  }
        //});
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gv=new Intent(Main5Activity.this,Main16Activity.class);
                startActivity(gv);
            }
        });
        se.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ds=new Intent(Main5Activity.this,Main17Activity.class);
                startActivity(ds);
            }
        });

        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lo=new Intent(Main5Activity.this,Main4Activity.class);
                startActivity(lo);
            }
        });
    }
}
