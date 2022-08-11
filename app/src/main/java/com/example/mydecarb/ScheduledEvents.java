package com.example.mydecarb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mydecarb.ui.notifications.NotificationsFragment;

import java.awt.font.TextAttribute;

public class ScheduledEvents extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduled_events);
        final TextView textView1 = (TextView) findViewById(R.id.scheduled_event1);
        textView1.setText("Bike Travel");
        textView1.setTextColor(Color.GREEN);
        final TextView textView2 = (TextView) findViewById(R.id.scheduled_event2);
        textView2.setText("Electricity");
        textView2.setTextColor(Color.GREEN);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateEvent.class);
                intent.putExtra("event_name", "Bike Travel");
                ScheduledEvents.this.startActivity(intent);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateEvent.class);
                intent.putExtra("event_name", "Electricity");
                ScheduledEvents.this.startActivity(intent);
            }
        });
    }
}