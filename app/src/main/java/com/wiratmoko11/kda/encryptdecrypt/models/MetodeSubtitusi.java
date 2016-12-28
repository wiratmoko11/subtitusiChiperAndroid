package com.wiratmoko11.kda.encryptdecrypt.models;

import android.util.Log;

/**
 * Created by Ultrabook on 12/23/2016.
 */

public class MetodeSubtitusi {
    private char[] key = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public String encrypt(String textNormal, int key){
        String hasilEnkripsi = "";
        int nilaiKarakter;
        Log.v("Metode Enkripsi", ""+textNormal.length());
        for (int i=0; i < textNormal.length(); i++){
            Log.v("Metode Enkripsi", ""+textNormal.charAt(i));
            nilaiKarakter = getNilaiCharacter(textNormal.charAt(i));
            if(textNormal.charAt(i) != ' '){
                hasilEnkripsi += this.key[(nilaiKarakter+key) % 26];
            }else{
                hasilEnkripsi += " ";
            }

        }
        return hasilEnkripsi;
    }

    public String decrypt(String textEncrypt, int key){
        String hasilDecrypt = "";
        int nilaiKarakter;
        for (int i = 0; i < textEncrypt.length() ; i++) {
            Log.v("Metode Enkripsi", ""+textEncrypt.charAt(i));
            nilaiKarakter = getNilaiCharacter(textEncrypt.charAt(i));

            if(textEncrypt.charAt(i) != ' '){
                hasilDecrypt += this.key[((nilaiKarakter - key) + 26) % 26];
            }else{
                hasilDecrypt += " ";
            }
        }
        return hasilDecrypt;
    }


    private int getNilaiCharacter(char karakter){
        int nilai = 0;
        for (int i = 1; i < key.length; i++) {
            if(karakter == key[i]){
                nilai = i;
            }
        }
        return nilai;
    }
}
