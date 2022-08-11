package com.example.mydecarb.ui.notifications;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mydecarb.CreateEvent;
import com.example.mydecarb.ScheduledEvents;
import com.example.mydecarb.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView scheduledEvents = binding.scheduledEvents;
        scheduledEvents.setText("Scheduled Events");
        scheduledEvents.setTextColor(Color.GREEN);
        final TextView createEvent = binding.createEvent;
        createEvent.setText("Create Event");
        createEvent.setTextColor(Color.GREEN);

        scheduledEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), ScheduledEvents.class);
                NotificationsFragment.this.startActivity(intent);
            }
        });
        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CreateEvent.class);
                intent.putExtra("event_name", "");
                NotificationsFragment.this.startActivity(intent);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}