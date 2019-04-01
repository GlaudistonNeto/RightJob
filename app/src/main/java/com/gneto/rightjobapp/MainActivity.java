package com.gneto.rightjobapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mInfo;
    Button mCli, mTrab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInfo = (TextView)findViewById(R.id.tvMInfo);
        mCli = (Button)findViewById(R.id.btnMCli);
        mTrab= (Button)findViewById(R.id.btnMTrab);

        mCli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mTrab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AlterarTrabActivity.class);
                startActivity(intent);
            }
        });
    }
}
