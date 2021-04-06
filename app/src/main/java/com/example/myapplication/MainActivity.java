package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        btnLogin = findViewById(R.id.btsignIn);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail = findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword = findViewById(R.id.edPassword);

        //membuat fingfi onclik pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = edemail.getText().toString();
                String password = edpassword.getText().toString();

                //mengeset email yang benar
                String email = "admin@mail.com";

                //mengeset password yang benar
                String pass = "123456";

                if (nama.equals("admin@mail.com") && password.equals("123456")) {
                    //jika login berhasil
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses", Toast.LENGTH_LONG);
                    t.show();
                    //membuat objek bundle
                    Bundle b = new Bundle();
                    //memasukkan value dari variabel nama dengan kunci "a"
                    // dan dimasukkan kedalam bundle
                    b.putString("a", nama.trim());

                    //memasukkan value dari variable password dengan kunci "b"
                    // dan dimasukkan kedalam bundle
                    b.putString("b", password.trim());

                    //membuat objek intent berpindah activity dari mainactivity ke ActivityHasil
                    Intent i = new Intent(getApplicationContext(), Home.class);

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
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //Membuat kondis jika yang dipilih adalah mnDaftar
        if (item.getItemId() == R.id.mndaftar)
        {
            //Method untuk memanggil activity "DaftarActivity"
            Intent i = new Intent(getApplicationContext(), Daftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}





