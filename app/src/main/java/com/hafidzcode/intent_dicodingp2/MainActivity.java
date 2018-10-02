package com.hafidzcode.intent_dicodingp2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//belajar dasar-dasar penggunaan intent secara umum di proyek aplikasi Android.
//4 intent secara eksplisit dan 1 secara implisit dengan satu di antaranya mencakup nilai balik dari activity yang dijalankan.

//kalau contoh disini objek untuk event click dibuat menggunakan implementasi yang nantinya dibuat didalam method onClick hasil dr implementasi yg terletak di luar onCreate


//todo 2 implementasi listener view onClick
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //todo 3 deklarasi
    //btnMoveActivity = untuk logika intent dalam memindahkan satu Activity ke Activity lain dengan tidak membawa data (intent sederhana)
    private Button btnMoveActivity;
    //btnMoveWithDataActivity = memindahkan satu Activity ke Activity lain dengan membawa data dan disetnya secara sendiri2
    private Button btnMoveWithDataActivity;
    //btnMoveWithObject = intent yang di dalamnya akan membawa data dengan Plain Old Java Object (POJO) ke activity tujuan.
    //dengan parcelable
    //dengan object
    private Button btnMoveWithObject;
    //btnDialPhone = intent implicit
    private Button btnDialPhone;
    //result activity
    private  Button btnMoveForResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //todo 4 inisialisasi
        btnMoveActivity = (Button)findViewById(R.id.btn_move_activity);
        btnMoveWithDataActivity = (Button)findViewById(R.id.btn_move_activity_data);
        btnMoveWithObject = (Button)findViewById(R.id.btn_move_activity_object);
        btnDialPhone = (Button)findViewById(R.id.btn_dial_number);
        btnMoveForResult = (Button)findViewById(R.id.btn_move_for_result);
        tvResult = (TextView)findViewById(R.id.tv_result);

        //todo 5 event click
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObject.setOnClickListener(this);
        btnDialPhone.setOnClickListener(this);
        btnMoveForResult.setOnClickListener(this);



        //cara pertama untk intent yg biasa sy gunakan
//        btnMoveActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), MoveActivity.class);
//            }
//        });
    }

    //hasil implements
    @Override
    public void onClick(View view) {
        //todo 6
        switch (view.getId()){
            case R.id.btn_move_activity:
                //intent explicit tanpa membawa data hanya pindah activity
                Intent moveIntent = new Intent(MainActivity.this, MoveActivity.class);
                //metode ini akan menjalankan activity baru tanpa membawa data
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                //intent explicit dgn membawa data
                // intent yang didalamnya akan membawa data ke activity tujuan
                Intent moveWithDataIntent = new Intent(MainActivity.this, MoveWithDataActivitiy.class);
                moveWithDataIntent.putExtra(MoveWithDataActivitiy.EXTRA_NAME, "DicodingAcademy-HafidzQode");
                moveWithDataIntent.putExtra(MoveWithDataActivitiy.EXTRA_AGE, 5);
                //metode ini akan menjalankan activity baru dengan membawa data secara sendiri2 tdk dgn pojo
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                //intent explicit dgn membawa data menggunakan object/parcelable/pojo
                //pindah activity dengan object
                //kita menciptakan sebuah obyek Person bernama mPerson yang mana kelas tersebut adalah Parcelable
                //Kita atur semua data sesuai dengan propertinya
                Person mPerson = new Person();
                mPerson.setName("DicodingAcademy");
                mPerson.setAge(5);
                mPerson.setEmail("academy@dicoding.com");
                mPerson.setCity("Bandung");
                //Setelah selesai kita akan mengirimkan obyek tersebut ke MoveWithObjectActivity melalui sebuah intent
                Intent moveWithObjectIntent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                //Metode putExtra() yang kita pilih saat ini adalah putExtra(String name, Parcelable value).
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveWithObjectIntent);
                break;
            case R.id.btn_dial_number:
                //membuat implicit intent
                //dalam membuat implicit intent kita tidak perlu membuat activity baru
                String phoneNumber = "082112844735";
                //kenapa bs lgsg masuk ke dial, krn kita pakai ACTION_DIAL jd lgsg ke set kesitu
                //baris bwh ini deklarasi dgn memberi Intent nama/variable dialPhoneIntent yg diinisialisasikan dgn scripts dibawah ini (mengatur kmn intent trsbt berlangsung)
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                //stlh diinisialisasi variable tinggal dipanggil di startActivity yaitu variable yg berisi scripts diatas
                //Aplikasi kita menjalankan intent untuk ACTION_DIAL melalui startActivity().
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_move_for_result:
                //pindah dr activity satu ke activity lain dgn result/untk result
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}
