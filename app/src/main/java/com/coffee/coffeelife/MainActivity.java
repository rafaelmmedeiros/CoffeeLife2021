package com.coffee.coffeelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import br.com.coffee.dao.CoffeeDAO;

public class MainActivity extends AppCompatActivity {

    private TextView textTotalCooffees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTotalCooffees = (TextView) findViewById(R.id.tv_totalcoffees);

        totalCoffees();
    }

    public void registrarCafe(View v) {
        Intent intent = new Intent(MainActivity.this, RegistrarCafeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
    }

    public void totalCoffees() {
        CoffeeDAO coffeeDAO = new CoffeeDAO(this);

        long total = coffeeDAO.totalCoffees();
        String toshow = Long.toString(total);

        textTotalCooffees.setText(toshow);
    }

}