package com.vikcandroid.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioGroup cRadioGroup;
    RadioGroup rRadioGroup;
    RadioGroup fRadioGroup;
    RadioGroup oRadioGroup;
    RadioGroup kRadioGroup;

    // Radio buttons
    // Release year radio buttons
    private RadioButton twentyTen, nineteenSixty, twentyEleven;

    // Codename radio buttons
    private RadioButton oreo, kitkat, nougat;

    // founder radio buttons
    private RadioButton rubin, gates, trump;

    // owner radio button
    private RadioButton google, microsoft, facebook;

    // kernel radio buttons
    private RadioButton linux, windows, unix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rRadioGroup = findViewById(R.id.release_radio_group);
        cRadioGroup = findViewById(R.id.codename_radio_group);
        fRadioGroup = findViewById(R.id.founder_radio_group);
        oRadioGroup = findViewById(R.id.owner_radio_group);
        kRadioGroup = findViewById(R.id.kernel_radio_group);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.hide();

                Snackbar.make(view, "Yaas!! You got everything correct!", Snackbar.LENGTH_LONG).show();
                fab.show();
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
        if (id == R.id.action_reset) {
            // Clear all the check radio buttons
            cRadioGroup.clearCheck();
            oRadioGroup.clearCheck();
            fRadioGroup.clearCheck();
            rRadioGroup.clearCheck();
            kRadioGroup.clearCheck();
        }

        return super.onOptionsItemSelected(item);
    }
}
