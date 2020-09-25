package com.coffee.coffeelife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.coffee.dao.CoffeeDAO;
import br.com.coffee.model.Coffee;

public class HistoricoActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        historico();
    }

    @Override
    protected void onResume() {
        super.onResume();
        historico();
    }

    public void historico() {
        CoffeeDAO coffeeDAO = new CoffeeDAO(this);
        listView = (ListView) findViewById(R.id.list_view_historico);

        ArrayList<Coffee> coffees = coffeeDAO.recuperarTodos();
        ArrayList<String> coffeesDetalhado = new ArrayList<String>();
        for (Coffee coffee : coffees) {
            coffeesDetalhado.add("Tipo: " + coffee.getTipo());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, coffeesDetalhado);
        listView.setAdapter(arrayAdapter);
    }
}