package ru.jdrm.jdrmapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import ru.jdrm.jdrmapp.design.PlantItem;
import ru.jdrm.jdrmapp.design.NavBarActivity;


public class PlantItemChoose extends AppCompatActivity {

    String [] factoies = {
            "Воронежский завод",
            "Уссурийский завод",
            "Челябинский завод",
            "Ярославский завод",
            "Астраханский завод",
            "Оренбургский завод",
            "Улан-Удэнский завод",
            "Ростовский-на-Дону завод"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.plantitemchoose);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, factoies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        PlantItem factory = new PlantItem();
                        factory.setFactories((parent.getItemAtPosition(pos)).toString());
                    }
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
    }

    public void startNewActivity_2(View v) {
        startActivity( new Intent(this, NavBarActivity.class));
    }
}



