package com.coffee.coffeelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import br.com.coffee.dao.CoffeeDAO;

public class MainActivity extends AppCompatActivity {

    private TextView textTotalCooffees;
    private TextView textTotalCooffeesHoje;
    private TextView textTotalLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTotalCooffees = (TextView) findViewById(R.id.tv_total_coffees);
        textTotalCooffeesHoje = (TextView) findViewById(R.id.tv_total_coffees_hoje);
        textTotalLitros = (TextView) findViewById(R.id.tv_total_coffees_litros);
    }

    @Override
    protected void onResume() {
        super.onResume();
        totalCoffees();
        totalCoffeesHoje();
    }

    // ACTIVITIES INTENTS
    public void registrarCafe(View v) {
        Intent intent = new Intent(MainActivity.this, RegistrarCafeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    // FUNÇÔES DE ESTATISTICAS
    public void totalCoffees() {
        CoffeeDAO coffeeDAO = new CoffeeDAO(this);

        long total = coffeeDAO.totalCoffees();
        String totalShow = Long.toString(total);

        textTotalCooffees.setText(totalShow);
    }

    public void totalCoffeesHoje() {
        CoffeeDAO coffeeDAO = new CoffeeDAO(this);

        long total = coffeeDAO.totalCoffeesHoje();
        String toshow = Long.toString(total);

        Double litros = total * 0.12;

        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        String str = nf.format(litros);

        textTotalLitros.setText(str);
        textTotalCooffeesHoje.setText(toshow);
    }

}