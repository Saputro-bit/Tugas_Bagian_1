package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //deklarasi variabel untuk Button
    Button btnLogin;

    //Deklarasi variabel untuk EditText
    EditText edemail, edpassword;

    //Deklarasi variabel untuk menyimpan email dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnLogin=findViewById(R.id.btsignIn);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fingfi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //menyimpan input user di edittext email ke dalam variabel nama
                nama = edemail.getText().toString();

                //menyimpan input user di edittext password ke dalam variabel nama
                password = edemail.getText().toString();

                //menengeset email yang benar
                String email = "muhammadnoorsaputro23@mail.com";
                //meneset password yang benar
                String pass = "123456";

                //mengecek apakahh edittext email dan password terdapat isi atau tidak
                if (nama.isEmpty() || password.isEmpty()) {
                    //membuat variabel toast dan menampilkan pesan "Login Sukse"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses",
                            Toast.LENGTH_LONG);
                    //menampilan toast
                    t.show();
                } else {

                    //mengecek apakaj isi dari rmail dan password sudah sama dengan email dan
                    //password yang sudah di set
                    if (nama.equals(email) && password.equals(pass)) {
                        //membuat variabel toast dan menampilkan pesan "login Sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login sukse",
                                Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                        //membuat objek bundle
                        Bundle b = new Bundle();

                        //memasukkan value dari variabel nama kunci "a"
                        //dan dimasukkan ke dalam bundle
                        b.putString("a", nama.trim());

                        //memasukkan value dari variabel password dengan kunci "b"
                        //dan dimaasukkan kedalam bundle
                        b.putString("b", password.trim());

                        //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke ActivityHasil
                        i.putExtras(b);
                        //berpindah ke ActivityHasil
                        startActivity(i);
                    } else {
                        //membuat variabel toast dan membut toast dan menampilkan pesan "Login Sukses"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                    }
                }
            }
        });
    }
}




