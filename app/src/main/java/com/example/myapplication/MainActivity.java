package com.example.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private EditText name ,height ,weight;
    private TextView BMI;
    float bmi;

    public void Go(View view) {

        name = findViewById(R.id.name);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        BMI = findViewById(R.id.BMI);

        bmi = Float.parseFloat(weight.getText().toString())/Float.parseFloat(height.getText().toString())/Float.parseFloat(height.getText().toString());

        BMI.setText("your BMI is" + bmi);

        if(bmi < 18.5)
            getWindow().setBackgroundDrawableResource(R.drawable.fly);
        else if(bmi > 25)
            getWindow().setBackgroundDrawableResource(R.drawable.rip);
        else
            getWindow().setBackgroundDrawableResource(R.drawable.good);

    }
}
