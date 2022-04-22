package com.example.miniproject1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_item extends AppCompatActivity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        int image_s = getIntent().getIntExtra("image_s", 0);
        String name = getIntent().getStringExtra("Restaurant");
        String biaya = getIntent().getStringExtra("biaya");
        String waktuJarak = getIntent().getStringExtra("waktuJarak");
        String estimasi = getIntent().getStringExtra("estimasi");

        TextView nameTextView = findViewById(R.id.restaurant);
        TextView biayaTextView = findViewById(R.id.biaya_kirim);
        TextView jarakTextView = findViewById(R.id.jarak);
        TextView waktuTextView = findViewById(R.id.waktu_pengiriman);
        ImageView imageview = findViewById(R.id.image_item);

        nameTextView.setText(name);
        biayaTextView.setText(biaya);
        jarakTextView.setText(waktuJarak);
        waktuTextView.setText(estimasi);
        imageview.setImageResource(image_s);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onDeafultToggleClick(View view) {
        Toast.makeText(this, "Shared", Toast.LENGTH_SHORT).show();
    }

    public void onCustomToggleClick(View view) {
        Toast.makeText(this, "Ditambahkan Ke Favorit", Toast.LENGTH_SHORT).show();
    }
}