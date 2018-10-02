package com.hafidzcode.intent_dicodingp2;

import android.os.Parcel;
import android.os.Parcelable;

//jadi disini kita membuat intent dgn membawa data tapi datanya kita gk buat satu2 kyk di intent "Pindah activity dengan data" disini kita akan membuat data lebih dari satu tanpa set one by one jd disetting secara langsung, nah kita akan membuat intent dgn  melakukan pengiriman data dari satu activity ke activity lainnya. dari kegunaan tersebut kita menggunakan obyek parcelable.
//todo 1 dalam membuat intent membawa data dgn pojo
//Sebelum membuat obyek parcelable, kita buat kelas Java POJO terlebih dahulu
public class Person implements Parcelable {

    //membuat setter n getter menggunakan pojo (tanpa perlu ngoding satu2)

    //todo 2 buat variable yg ingin di setter n getter
    //tentukan terlebih dahulu variable apa saja yang akan digunakan.
    private String name;
    private int age;
    private String email;
    private String city;

    //sebelum di generate ada scripts di bawah ini tp stlh di generate scripts ini hilang
    //public String getName() {
    //return name;
    //}
    //setelah itu right click workspace > generate > getter n setter

    //todo 3 generate > setter n getter
    //hasil dari generate > setter n getter,
    //Secara otomatis metode setter dan getter masing-masing variabel akan dibuatkan.
    // dimana generate td membaca dr variable yg kita buat diatas lalu di set variable yg kita inginkan untuk di generate
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;

//notes : kenpa td diatas kita generate2an krn kita akan pindah activity dgn membawa data jadi ada action set data dan get data dari variale yg udh kita buat tadi, makannya kita pakai setter n getter untk cara lain tp daasarnya sm kyk di pindah activity dengan data cuma krn yg itu hny membawa data yg sdikit bs diatur satu2 tp krn skrg kita mau membawa dan mengambil data yg bnyk kita pakai cara mudah menggunkan setter n getter from generate

    //todo 4 menambahkan plugin Android Parcelable Generator pada Android Studio
    //Plugin ini berguna untuk mengubah kelas POJO menjadi obyek Parcelable
    //workspace ini kan kelas pojo nah kita akan ubah mnjd obyek parcelable
    //todo 5 setelah plugin Parcelable generator terinstal saatnya kita implementasikan pada kelas Person right click >> generate >> parcelable

    }
    //hasil dari todo5
    //dibawah ini beragam metode parcelable untuk kelas Person
    //Sekarang kelas Person sudah sah menjadi kelas parcelable dan dapat dikirimkan ke activity lain melalui intent.
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeString(this.email);
        dest.writeString(this.city);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
        this.email = in.readString();
        this.city = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }

//  Sekarang waktunya kita implementasikan pada intent
    };
}
