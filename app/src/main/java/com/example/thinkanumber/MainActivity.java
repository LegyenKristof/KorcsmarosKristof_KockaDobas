package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2;
    private Button btn1, btn2, btn3, btn4;
    private TextView textView1;
    private String eredmenyek;
    private boolean ketKocka, dobhatE;
    private int animacioIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dobhatE){
                    imageView2.setVisibility(View.GONE);
                    ketKocka = false;
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dobhatE){
                    imageView2.setVisibility(View.VISIBLE);
                    ketKocka = true;
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dobhatE){
                    dobhatE = false;
                    dobasAnimacio();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dobhatE){
                    reset();
                }
            }
        });
    }

    private void dobasAnimacio(){
        if (animacioIndex < 10){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    kepBeallitas((int) (Math.random() * 6 + 1), imageView1);
                    if (ketKocka){
                        kepBeallitas((int) (Math.random() * 6 + 1), imageView2);
                    }
                    animacioIndex++;
                    dobasAnimacio();
                }
            }, 100);
        }
        else{
            animacioIndex = 0;
            dobas();
        }
    }

    private void reset(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Reset");
        builder.setMessage("Biztos, hogy törölni szeretné az eddigi dobásokat");
        builder.setPositiveButton("IGEN", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                eredmenyek = "";
                textView1.setText("");
            }
        });
        builder.setNegativeButton("NEM", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
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
        String sor = randomSzam1 + "";
        if (ketKocka){
            int randomSzam2 = (int) (Math.random() * 6 + 1);
            kepBeallitas(randomSzam2, imageView2);
            sor = String.format("%d (%d+%d)", randomSzam1 + randomSzam2, randomSzam1, randomSzam2);
        }
        Toast.makeText(getApplicationContext(), sor, Toast.LENGTH_SHORT).show();
        eredmenyek = sor + "\n" + eredmenyek;
        textView1.setText(eredmenyek);
        dobhatE = true;
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
        dobhatE = true;
        animacioIndex = 0;
    }
}