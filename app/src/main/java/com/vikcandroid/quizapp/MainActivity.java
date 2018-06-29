package com.vikcandroid.quizapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup cRadioGroup;
    RadioGroup rRadioGroup;
    RadioGroup fRadioGroup;
    RadioGroup oRadioGroup;
    RadioGroup kRadioGroup;

    // Radio buttons
    // Release year radio buttons
    private RadioButton releaseRadioButton;

    // Codename radio buttons
    private RadioButton codenameRadioButton;

    // founder radio buttons
    private RadioButton founderRadioButton;

    // owner radio button
    private RadioButton ownerRadioButton;

    // kernel radio buttons
    private RadioButton kernelRadioButton;

    // Git creator EditText
    private AppCompatEditText gitCreator;

    // Language checkboxes
    private CheckBox javaCheckbox, kotlinCheckbox, swiftCheckbox, cppCheckbox;


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

        gitCreator = findViewById(R.id.creator_name_edit);

        javaCheckbox = findViewById(R.id.java_checkbox);
        kotlinCheckbox = findViewById(R.id.kotlin_checkbox);
        swiftCheckbox = findViewById(R.id.swift_checkbox);
        cppCheckbox = findViewById(R.id.c_checkbox);

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int releaseId = rRadioGroup.getCheckedRadioButtonId();
                int codenameId = cRadioGroup.getCheckedRadioButtonId();
                int founderId = fRadioGroup.getCheckedRadioButtonId();
                int ownerId = oRadioGroup.getCheckedRadioButtonId();
                int kernelId = kRadioGroup.getCheckedRadioButtonId();

                codenameRadioButton = findViewById(codenameId);
                releaseRadioButton = findViewById(releaseId);
                founderRadioButton = findViewById(founderId);
                ownerRadioButton = findViewById(ownerId);
                kernelRadioButton = findViewById(kernelId);


                String codeName = codenameRadioButton.getText().toString();
                String release = releaseRadioButton.getText().toString();
                String founder = founderRadioButton.getText().toString();
                String owner = ownerRadioButton.getText().toString();
                String kernel = kernelRadioButton.getText().toString();

                String gitCreatorString = gitCreator.getText().toString();

                if (codeName.equals("Oreo") && release.equals("2010") && founder.equals("Andy Rubin")
                        && owner.equals("Google") && kernel.equals("Linux") && gitCreatorString.equals("Linus Torvalds")
                        && javaCheckbox.isChecked() && kotlinCheckbox.isChecked() && cppCheckbox.isChecked()) {
                    Toast.makeText(MainActivity.this, "Congratulations!!! You got everything correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "One or more answers are not correct", Toast.LENGTH_SHORT).show();
                }

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

            gitCreator.setText("");
            javaCheckbox.setChecked(false);
            kotlinCheckbox.setChecked(false);
            cppCheckbox.setChecked(false);
            swiftCheckbox.setChecked(false);
        }

        return super.onOptionsItemSelected(item);
    }
}
