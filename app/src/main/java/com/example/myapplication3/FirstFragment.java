package com.example.myapplication3;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication3.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    TextView tv;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tv = binding.textviewFirst;
        tv.setTextSize(40);

        tv.append("Модель :" + Build.MODEL + "\n");
        tv.append("Устройство: " + Build.DEVICE + "\n");
        tv.append("Брнед: " + Build.BRAND + "\n");
        tv.append("Серийник: " + Build.SERIAL + "\n");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}