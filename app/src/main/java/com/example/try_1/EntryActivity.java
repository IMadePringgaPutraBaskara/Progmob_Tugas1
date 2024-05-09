package com.example.try_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class EntryActivity extends AppCompatActivity {

    private EditText usernameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_entry);

        // Inisialisasi EditText untuk username
        usernameEditText = findViewById(R.id.username_entry);

        // Inisialisasi tombol untuk logout
        Button logoutButton = findViewById(R.id.logout_btn);

        // Menambahkan aksi klik pada tombol logout
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat intent untuk kembali ke MainActivity
                Intent intent = new Intent(EntryActivity.this, MainActivity.class);
                startActivity(intent); // Memulai MainActivity
                finish(); // Menutup EntryActivity
            }
        });

        // Menangani pengiriman data username ke EntryActivity dari MainActivity
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("USERNAME")) {
            String username = intent.getStringExtra("USERNAME");
            // Set text dari EditText username
            usernameEditText.setText(username);
        }
    }
}
