package com.example.egzamin_zawodowy_galeria;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageViewKot;
    Button buttonPrev;
    Button buttonNext;
    Switch switchTlo;
    LinearLayout main;
    ArrayList<Obraz> obrazki = new ArrayList<>();
    private int AktualneZdjecie = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        imageViewKot = findViewById(R.id.imageViewKot);
        buttonPrev = findViewById(R.id.buttonPrev);
        buttonNext = findViewById(R.id.buttonNext);
        switchTlo = findViewById(R.id.switchTlo);
        main = findViewById(R.id.main);

        obrazki.add(new Obraz(
                R.drawable.kot1
        ));
        obrazki.add(new Obraz(
                R.drawable.kot2
        ));
        obrazki.add(new Obraz(
                R.drawable.kot3
        ));
        obrazki.add(new Obraz(
                R.drawable.kot4
        ));

        buttonPrev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(AktualneZdjecie == 0)
                        {
                            AktualneZdjecie = 3;
                            UstawObraz();
                        }
                        else{

                            AktualneZdjecie--;
                            UstawObraz();
                        }
                    }
                }
        );
        buttonNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(AktualneZdjecie == 3)
                        {
                            AktualneZdjecie = 0;
                            UstawObraz();
                        }
                        else
                        {
                            AktualneZdjecie++;
                            UstawObraz();
                        }
                    }
                }
        );
    }
    public void UstawObraz()
    {
        imageViewKot.setImageResource(obrazki.get(AktualneZdjecie).getObraz());
    }
}