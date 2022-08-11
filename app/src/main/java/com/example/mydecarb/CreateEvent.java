package com.example.mydecarb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CreateEvent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        Intent intent = getIntent();
        String value = intent.getStringExtra("event_name");
        final TextView evnt_lbl = (TextView) findViewById(R.id.event_name_label);
        final TextView strt_time_lbl = (TextView) findViewById(R.id.start_time_label);
        final TextView end_time_lbl = (TextView) findViewById(R.id.end_time_label);
        final TextView loc_lbl = (TextView) findViewById(R.id.location_label);
        final TextView end_loc_lbl = (TextView) findViewById(R.id.end_location_label);
        final TextView type_lbl = (TextView) findViewById(R.id.type_label);
        final TextView src_lbl = (TextView) findViewById(R.id.source_label);
        evnt_lbl.setTextColor(Color.GREEN);
        strt_time_lbl.setTextColor(Color.GREEN);
        end_time_lbl.setTextColor(Color.GREEN);
        loc_lbl.setTextColor(Color.GREEN);
        end_loc_lbl.setTextColor(Color.GREEN);
        type_lbl.setTextColor(Color.GREEN);
        src_lbl.setTextColor(Color.GREEN);
        final EditText evnt = (EditText) findViewById(R.id.event_name);
        final EditText strt_time = (EditText) findViewById(R.id.start_time);
        final EditText end_time = (EditText) findViewById(R.id.end_time);
        final EditText loc = (EditText) findViewById(R.id.location);
        final EditText end_loc = (EditText) findViewById(R.id.end_location);
        final EditText type = (EditText) findViewById(R.id.type);
        final EditText src = (EditText) findViewById(R.id.source);
        evnt.setTextColor(Color.GREEN);
        strt_time.setTextColor(Color.GREEN);
        end_time.setTextColor(Color.GREEN);
        loc.setTextColor(Color.GREEN);
        end_loc.setTextColor(Color.GREEN);
        type.setTextColor(Color.GREEN);
        src.setTextColor(Color.GREEN);
        evnt.setText(value);
        if (value.equals("Bike Travel")){
            strt_time.setText("Daily 6:00PM");
            end_time.setText("Daily 8:00PM");
            loc.setText("Chennai");
            end_loc.setText("Chennai");
            type.setText("Scheduled Event");
            src.setText("Hero 200 CC Bike");
        }
        if (value.equals("Electricity")){
            strt_time.setText("Monthly 10:00AM");
            end_time.setText("N/A");
            loc.setText("Bengaluru");
            end_loc.setText("N/A");
            type.setText("Scheduled Event");
            src.setText("Home");
        }
        final Button save = (Button) findViewById(R.id.Save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Event Saved!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                CreateEvent.this.finish();
            }
        });
    }
}