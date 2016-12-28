package com.wiratmoko11.kda.encryptdecrypt.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wiratmoko11.kda.encryptdecrypt.R;
import com.wiratmoko11.kda.encryptdecrypt.models.MetodeSubtitusi;

import static java.lang.Integer.parseInt;

/**
 * Created by Ultrabook on 12/23/2016.
 */

public class EncryptFragment extends Fragment {


    private Button btnEncrypt;
    private EditText editextNormal;
    private EditText editTextEncrypted;
    private EditText editTextKunci;
    public EncryptFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle savedInstanceState) {
        View rootFragment = inflater.inflate(R.layout.fragment_encrypt, view, false);

        btnEncrypt = (Button) rootFragment.findViewById(R.id.btnEncrypt);
        editextNormal = (EditText) rootFragment.findViewById(R.id.editTextNormal);
        editTextEncrypted = (EditText) rootFragment.findViewById(R.id.editTextEncrypted);
        editTextKunci = (EditText) rootFragment.findViewById(R.id.editTextKunci);

        btnEncrypt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MetodeSubtitusi metode = new MetodeSubtitusi();
                String key = editTextKunci.getText().toString();
                String hasilEnkripsi = metode.encrypt(editextNormal.getText().toString(), parseInt(key));
                editTextEncrypted.setText(hasilEnkripsi);
            }
        });


        return rootFragment;
    }
}
