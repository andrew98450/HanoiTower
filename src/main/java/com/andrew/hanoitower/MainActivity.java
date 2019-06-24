package com.andrew.hanoitower;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton imagebt1;
    ImageButton imagebt2;
    ImageButton imagebt3;
    ImageButton imagebt4;
    ImageButton imagebt5;
    ImageButton imagebt6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagebt1 = (ImageButton)findViewById(R.id.imageButton_level1);
        imagebt2 = (ImageButton)findViewById(R.id.imageButton_level2);
        imagebt3 = (ImageButton)findViewById(R.id.imageButton_level3);
        imagebt4 = (ImageButton)findViewById(R.id.imageButton_level4);
        imagebt5 = (ImageButton)findViewById(R.id.imageButton_level5);
        imagebt6 = (ImageButton)findViewById(R.id.imageButton_level6);
        imagebt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Level1Activity.class);
                startActivity(intent);
            }
        });
        imagebt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Level2Activity.class);
                startActivity(intent);
            }
        });
        imagebt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Level3Activity.class);
                startActivity(intent);
            }
        });
        imagebt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Level4Activity.class);
                startActivity(intent);
            }
        });
        imagebt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Level5Activity.class);
                startActivity(intent);
            }
        });
        imagebt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Level6Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item_exit:
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
