package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2;
    private Button btn1, btn2, btn3, btn4;
    private TextView textView1;
    private String eredmenyek;
    private boolean ketKocka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setVisibility(View.GONE);
                ketKocka = false;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView2.setVisibility(View.VISIBLE);
                ketKocka = true;
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dobas();
            }
        });
    }

    private void kepBeallitas(int szam, ImageView imageView){
        switch (szam){
            case 1:
                imageView.setImageResource(R.drawable.kocka1);
                break;
            case 2:
                imageView.setImageResource(R.drawable.kocka2);
                break;
            case 3:
                imageView.setImageResource(R.drawable.kocka3);
                break;
            case 4:
                imageView.setImageResource(R.drawable.kocka4);
                break;
            case 5:
                imageView.setImageResource(R.drawable.kocka5);
                break;
            case 6:
                imageView.setImageResource(R.drawable.kocka6);
                break;
        }
    }

    private void dobas(){
        int randomSzam1 = (int) (Math.random() * 6 + 1);
        kepBeallitas(randomSzam1, imageView1);
        String sor = randomSzam1 + "\n";
        if (ketKocka){
            int randomSzam2 = (int) (Math.random() * 6 + 1);
            kepBeallitas(randomSzam2, imageView2);
            sor = String.format("%d (%d+%d)\n", randomSzam1 + randomSzam2, randomSzam1, randomSzam2);
        }
        eredmenyek = sor + eredmenyek;
        textView1.setText(eredmenyek);
    }

    private void init(){
        imageView1 = findViewById(R.id.imgView1);
        imageView2 = findViewById(R.id.imgView2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        textView1 = findViewById(R.id.textView1);
        eredmenyek = "";
        ketKocka = true;
    }
}