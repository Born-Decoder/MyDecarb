package com.example.mydecarb.ui.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mydecarb.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView welcome = binding.Welcome;
        final TextView currentUnits = binding.currentUnits;
        final TextView previousUnits = binding.previousUnits;
        final TextView lifetimeUnits = binding.lifetimeUnits;
        final TextView top = binding.Top;
        final TextView suggestion1 = binding.Suggestion1;
        final TextView suggestion2 = binding.Suggestion2;
        final TextView suggestion3 = binding.Suggestion3;
        final TextView currentUnitsValue = binding.currentUnitsValue;
        final TextView previousUnitsValue = binding.previousUnitsValue;
        final TextView lifetimeUnitsValue = binding.lifetimeUnitsValue;
        welcome.setText("Hi User!");
        currentUnits.setText("Current Month Emissions");
        previousUnits.setText("Previous Month Emissions");
        lifetimeUnits.setText("Total Recorded Emissions");
        top.setText("You are having less emissions than 60 percentile of people!");
        suggestion1.setText("Use LEDs to save your Electricity around 50 to 80%!");
        suggestion2.setText("Use public transport instead of cars whenever possible!");
        suggestion3.setText("Planning your trips in advance can help you to optimise emissions!");
        currentUnitsValue.setText("20 Kg");
        previousUnitsValue.setText("265 Kg");
        lifetimeUnitsValue.setText("3800 Kg");
        welcome.setTextColor(Color.GREEN);
        currentUnits.setTextColor(Color.GREEN);
        previousUnits.setTextColor(Color.GREEN);
        lifetimeUnits.setTextColor(Color.GREEN);
        top.setTextColor(Color.GREEN);
        suggestion1.setTextColor(Color.GREEN);
        suggestion2.setTextColor(Color.GREEN);
        suggestion3.setTextColor(Color.GREEN);
        currentUnitsValue.setTextColor(Color.GREEN);
        previousUnitsValue.setTextColor(Color.GREEN);
        lifetimeUnitsValue.setTextColor(Color.GREEN);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}