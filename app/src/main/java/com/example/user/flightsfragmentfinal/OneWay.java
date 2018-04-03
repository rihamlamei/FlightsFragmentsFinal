package com.example.user.flightsfragmentfinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class OneWay extends Fragment {


    public OneWay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one_way, container, false);
        ImageButton imageButtonUp = (ImageButton)rootView.findViewById(R.id.imageButton_upNumOfPassengersOneWay);
        ImageButton imageButtonDown = (ImageButton)rootView.findViewById(R.id.imageButton_downNumberOfPassengersOneWay);
        final TextView textViewNumOfPassengers = (TextView)rootView.findViewById(R.id.textView_numOfPassengersOneWay);
        imageButtonUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_passengers = textViewNumOfPassengers.getText().toString();
                int numOfPassengersSelected = Integer.parseInt(string_passengers) + 1;
                textViewNumOfPassengers.setText(String.valueOf(numOfPassengersSelected));
            }
        });
        imageButtonDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string_passengers = textViewNumOfPassengers.getText().toString();
                int checker = Integer.parseInt(string_passengers);
                if (checker>1){
                    int numOfPassengersSelected = checker - 1;
                    textViewNumOfPassengers.setText(String.valueOf(numOfPassengersSelected));
                }
                else
                    textViewNumOfPassengers.setText("1");

            }
        });
        return rootView;
    }

}
