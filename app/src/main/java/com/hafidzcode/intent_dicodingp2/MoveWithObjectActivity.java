package com.hafidzcode.intent_dicodingp2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveWithObjectActivity extends AppCompatActivity {

    //Dengan EXTRA_PERSON merupakan variabel static bertipe data string dan bernilai “extra_person”.
    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = (TextView) findViewById(R.id.tv_object_received);
        //baris bawah ini adalah pengambilan nilai
        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        //karena obyek ini terdiri dari beragam tipe data pada atribut atau propertinya,
        //kita hanya cukup membungkus itu semua kedalam obyek parcelable.
        //Melalui getIntent().getParcelableExtra(Key) Anda dapat mengambil nilai obyek Person yang sebelumnya telah dikirim dan menampilkannya seperti ini.
        String text = "Name : "+mPerson.getName()+", Email : "+mPerson.getEmail()+", Age : "+mPerson.getAge()+", Location : "+mPerson.getCity();
        tvObject.setText(text);
    }
}
