package com.example.signuploginrealtime;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookingPage extends Fragment {

    private Spinner spinnerChoices;
    private TextView description;
    private TextView price;

    private String[] choices = {"Choice 1", "Choice 2", "Choice 3", "Choice 4", "Choice 5"};
    private String[] descriptions = {"Description for Choice 1", "Description for Choice 2", "Description for Choice 3", "Description for Choice 4", "Description for Choice 5"};
    private String[] prices = {"$10", "$20", "$30", "$40", "$50"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_booking_page, container, false);

        // Initialize views
        spinnerChoices = view.findViewById(R.id.spinner_choices);
        description = view.findViewById(R.id.description);
        price = view.findViewById(R.id.price);

        // Set up the spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, choices);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerChoices.setAdapter(adapter);

        // Set listener for spinner item selection
        spinnerChoices.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                description.setText(descriptions[position]);
                price.setText(prices[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        return view;
    }
}
