package com.example.challenge1;

import static com.example.challenge1.R.id.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private EditText fullname, phone, address, startdate, enddate;
    private RelativeLayout homepage;
    private CheckBox work, smoke, workout;
    private RadioGroup sex;
    private FloatingActionButton submit;
    String fname, add, ph,  sdate, edate, result, gen;
    ArrayList<String> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullname = findViewById(R.id.fullname);
        phone = findViewById(R.id.phone);
        address = findViewById(R.id.address);
        startdate = findViewById(startDate);
        enddate = findViewById(endDate);
        submit = findViewById(R.id.submit);
        sex = findViewById(rdgpsex);
        homepage = findViewById(R.id.homepage);

        work = findViewById(R.id.work);
        smoke = findViewById(R.id.smoke);
        workout = findViewById(R.id.workout);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fname = fullname.getText().toString();
                add = address.getText().toString();
                ph = phone.getText().toString();
                sdate = startdate.getText().toString();
                edate = enddate.getText().toString();
                gen = result;

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                if (fname.isEmpty() || add.isEmpty() || ph.isEmpty() || sdate.isEmpty() || edate.isEmpty())
                {
                    Snackbar.make(homepage, "Please! fill all the Details", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Retry", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(intent);
                                }
                            }).show();
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Registration");
                    builder.setMessage("Name : " +fname+
                            "\nGender : "+gen+
                            "\nAddress : "+add+
                            "\nPhone : "+ph+
                            "\nStart Date : "+sdate+
                            "\nEnd Date : "+edate);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(intent);
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    builder.show();
                }
            }
        });

        sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                result = "";
                if (checkedId == R.id.male) {
                    result = "Male";
                } else if (checkedId == R.id.female) {
                    result = "Female";
                }
            }
        });

        if (work.isChecked())
            arrayList.add("Work");
        if (smoke.isChecked())
            arrayList.add("Smoke");
        if (workout.isChecked())
            arrayList.add("Workout");
    }
}