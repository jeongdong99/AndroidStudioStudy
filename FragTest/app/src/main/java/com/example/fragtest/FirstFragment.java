package com.example.fragtest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class FirstFragment extends Fragment {

    private PageViewModel pageViewModel;
    private TextView txtName;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // initialise ViewModel here
        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = (ViewGroup) inflater.inflate(
                R.layout.slide_page, container, false);
        ImageView tv = (ImageView) view.findViewById(R.id.imgView);
        tv.setImageResource(R.drawable.dahlia);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = view.findViewById(R.id.textViewName);
        pageViewModel.getName().observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                txtName.setText(s);
            }
        });

    }
}