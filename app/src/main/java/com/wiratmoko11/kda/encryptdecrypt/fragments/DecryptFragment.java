package com.wiratmoko11.kda.encryptdecrypt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.wiratmoko11.kda.encryptdecrypt.R;
import com.wiratmoko11.kda.encryptdecrypt.models.MetodeSubtitusi;

import static java.lang.Integer.parseInt;

/**
 * Created by Ultrabook on 12/23/2016.
 */

public class DecryptFragment extends Fragment {
    EditText textEncrypt;
    EditText textDecrypt;
    EditText textKunci;
    Button btnDecrypt;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_decrypt, container, false);

        textEncrypt = (EditText) rootView.findViewById(R.id.editTextEncrypt);
        textDecrypt = (EditText) rootView.findViewById(R.id.editTextDecrypt);
        textKunci = (EditText) rootView.findViewById(R.id.editTextKunci);
        btnDecrypt = (Button) rootView.findViewById(R.id.btnDecrypt);

        btnDecrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MetodeSubtitusi metode = new MetodeSubtitusi();
                String key = textKunci.getText().toString();
                String hasilEnkripsi = metode.decrypt(textEncrypt.getText().toString(), parseInt(key));
                textDecrypt.setText(hasilEnkripsi);
            }
        });

        return rootView;
    }
}
