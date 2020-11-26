package com.jackie.flash.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jackie.flash.R;

//TODO Do i really need to implement factory here?
public class FacebookFragment extends Fragment {
    public static Fragment newInstance() {
        return new FacebookFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_facebook, container, false);
        //initialize every layout item
        Button postButton = root.findViewById(R.id.post_button);
        postButton.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Create post clicked", Toast.LENGTH_SHORT).show();
        });
        return root;
    }

}
