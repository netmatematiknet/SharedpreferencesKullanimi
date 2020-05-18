package com.mobilprogramlar.sharedpreferenceskullanm;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

//www.ossmatematik.com
//www.mobilprogramlar.com

public class Adeneme extends AppCompatActivity {
    int yas2;
    String ad2;
    Boolean onay2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deneme);

        final SharedPreferences sharedPrefNT = getSharedPreferences("Ayarlar", MODE_PRIVATE);

        final EditText adEditText = findViewById(R.id.editTextad);
        final EditText yasEditText = findViewById(R.id.editTextyas);
        final CheckBox onayCheckBox = findViewById(R.id.CheckBoxonay);
        final Button kaydetBtn = findViewById(R.id.button_Kaydet);
        final Button okuBtn = findViewById(R.id.button_oku);
        final Button silTamaminiBtn = findViewById(R.id.button_tamamini_sil);
        final Button silSecileniBtn = findViewById(R.id.button_secileni_sil);

        kaydetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ad = adEditText.getText().toString();
                String yas = yasEditText.getText().toString();

                if (!ad.matches("")){
                    sharedPrefNT.edit().putString("isim", ad).apply();
                    //veya
                    //SharedPreferences.Editor editor = sharedPrefNT.edit();
                    //editor.putString("isim",ad);
                    //editor.apply();
                }
                if (!yas.matches("")){
                    int yas1 = Integer.parseInt(yas);
                    sharedPrefNT.edit().putInt("yas", yas1).apply();
                }
                if(onayCheckBox.isChecked()) {
                    boolean onay=true;
                    sharedPrefNT.edit().putBoolean("Onaylama", onay).apply();
                }else{
                    boolean onay=false;
                    sharedPrefNT.edit().putBoolean("Onaylama", onay).apply();
                }


            }
        });



        okuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ad2 = sharedPrefNT.getString("isim",null);
                yas2 = sharedPrefNT.getInt("yas",0);
                onay2 = sharedPrefNT.getBoolean("Onaylama",false);
                Toast.makeText(getApplicationContext(),"isim:"+ad2+" yas:"+yas2+" Onaylama:"+onay2,Toast.LENGTH_SHORT).show();
            }
        });
        silTamaminiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefNT.edit().clear().apply();
                //veya
                //SharedPreferences.Editor editor=sharedPrefNT.edit();
                //editor.clear().apply();
                Toast.makeText(getApplicationContext(),"Tüm Kayıtlar SİLİNDİ",Toast.LENGTH_SHORT).show();
            }
        });
        silSecileniBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPrefNT.edit().remove("isim").apply();
                //veya
                //SharedPreferences.Editor editor=sharedPrefNT.edit();
                //editor.remove("isim").apply();
                Toast.makeText(getApplicationContext(),"Sadece İsim SİLİNDİ",Toast.LENGTH_SHORT).show();
            }
        });


    }
}

