package com.android.anothertutorial;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IncrementAndDecrement extends Activity {
    TextView tvResult;
    Button btnIncrement,btnDecrement;
    int counter =0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.incrementanddecrement);
        tvResult=(TextView) findViewById(R.id.tvResult);
        btnIncrement=(Button) findViewById(R.id.btnIncrement);
        btnDecrement=(Button) findViewById(R.id.btnDecrement);

        btnIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                tvResult.setText("The Counter is "+counter);
            }
        });

        btnDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                tvResult.setText("The Counter is "+counter);
            }
        });
    }
}
