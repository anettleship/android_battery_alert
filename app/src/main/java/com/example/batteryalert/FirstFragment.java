package com.example.batteryalert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.batteryalert.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    TextView showCountTextView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View fragmentFirstLayout = binding.getRoot();

        // Get the count text view
        showCountTextView = fragmentFirstLayout.findViewById(R.id.textview_first);

        return fragmentFirstLayout;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        view.findViewById(R.id.toast_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast myToast = Toast.makeText(getActivity(), R.string.toast_message, Toast.LENGTH_SHORT);
                myToast.show();
            }
        });

        view.findViewById(R.id.count_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMe(view);
            }
        });
    }


    private void countMe(View view) {
        // Get the value of the text view
        String countString = showCountTextView.getText().toString();
        // Convert value to a number and increment it
        int count = Integer.parseInt(countString);
        count++;
        // Display the new value in the text view.
        showCountTextView.setText(Integer.toString(count));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}