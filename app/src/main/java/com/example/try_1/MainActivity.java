package com.example.try_1;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi EditText dan Button
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.login_btn);

        // Set inputType untuk passwordEditText menjadi numberPassword
        passwordEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        // Menambahkan aksi klik pada tombol login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan input dari EditText
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                // Melakukan validasi login
                if (isValidLogin(username, password)) {
                    // Jika valid, tampilkan pesan berhasil login
                    Toast.makeText(MainActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();

                    // Mulai EntryActivity setelah login berhasil
                    Intent intent = new Intent(MainActivity.this, EntryActivity.class);
                    // Sertakan inputan username sebagai extra dalam intent
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);

                } else {
                    // Jika tidak valid, tampilkan pesan kesalahan
                    Toast.makeText(MainActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method untuk melakukan validasi login
    private boolean isValidLogin(String username, String password) {
        // Validasi sederhana: username dan password harus "dede" dan "123"
        return username.equals("dede") && password.equals("123");
    }
}
