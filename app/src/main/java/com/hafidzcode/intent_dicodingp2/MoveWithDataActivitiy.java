package com.hafidzcode.intent_dicodingp2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

//buat Activity baru lagi seperti cara sebelumnya dan beri nama MoveWithDataActivity.
// Lalu, pada layout activity_move_with_data.xml kita tambahkan sebuah TextView ber-ID untuk menampilkan data yang dikirimkan dari Activity asal.
public class MoveWithDataActivitiy extends AppCompatActivity {

    public static String EXTRA_AGE = "extra_age";
    public static String EXTRA_NAME = "extra_name";
    private TextView tvDataReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data_activitiy);
        tvDataReceived = (TextView)findViewById(R.id.tv_data_received);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE, 0);
        String text = "Name : "+name+", Your Age : "+age;
        tvDataReceived.setText(text);

//contoh di atas (intent dari button pindah activity dengan data), pengiriman nilai data name dan age dilakukan secara SENDRI-SENDIRI.
//Yang satu bertipe data string dan yang lainnya bertipe data integer.

//Sekarang pertanyaanya bagaimana Anda bisa mengirimkan data dalam bentuk Plain Old Java Object (POJO) dari satu activity ke activity lain melalui intent?
//Caranya adalah dengan mengubah obyek POJO yang Anda miliki ke dalam bentuk obyek parcelable.
//Di Android Studio sudah ada fasilitas plugin bernama Android Parcelable Generator untuk memudahkan proses tersebut.
//mari Selanjutnya, kita akan membuat sbeuah intent yang di dalamnya akan membawa data dengan Plain Old Java Object (POJO) ke activity tujuan.
    }


}
