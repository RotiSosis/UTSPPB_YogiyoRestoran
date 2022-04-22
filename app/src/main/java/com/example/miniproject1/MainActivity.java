package com.example.miniproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements rv_interface{
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    List<String> listData;
    List<String> waktuJarak;
    List<String> biaya;
    List<String> estimasi;
    List<Integer> pic;


    int[] image = {R.drawable._01, R.drawable._02, R.drawable._03, R.drawable._04,
            R.drawable._05, R.drawable._06, R.drawable._07, R.drawable._08, R.drawable._09, R.drawable._10};



    /*
    static int[] image = {R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background,
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background, R.drawable.ic_launcher_background};
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyvlerViewData);
        listData = new ArrayList<>();
        waktuJarak = new ArrayList<>();
        biaya = new ArrayList<>();
        estimasi = new ArrayList<>();
        pic = new ArrayList<>();

        for(int p=0; p<10; p++){
            pic.add(image[p]);
        }



        listData = Arrays.asList(getResources().getStringArray(R.array.restaurant));
        waktuJarak = Arrays.asList(getResources().getStringArray(R.array.jarakTempuh));
        biaya = Arrays.asList(getResources().getStringArray(R.array.biaya));
        estimasi = Arrays.asList(getResources().getStringArray(R.array.estimasi));




        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterData = new AdapterData(this, listData, waktuJarak, pic, biaya, estimasi, this);
        recyclerView.setAdapter(adapterData);
        adapterData.notifyDataSetChanged();

    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, activity_item.class);

        intent.putExtra("image_s", pic.get(position));
        intent.putExtra("Restaurant", listData.get(position));
        intent.putExtra("biaya", biaya.get(position));
        intent.putExtra("waktuJarak", waktuJarak.get(position));
        intent.putExtra("estimasi", estimasi.get(position));

        startActivity(intent);
    }

}