package com.coffee.coffeelife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.coffee.dao.CoffeeDAO;
import br.com.coffee.model.Coffee;

public class RegistrarCafeActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cafe);

        listView = (ListView) findViewById(R.id.lstView);
    }

    public void registrarCoffee(View v) {

        Coffee coffee = new Coffee();
        CoffeeDAO CoffeeDAO = new CoffeeDAO(this);

        //popular os dados do coffee
        coffee.setTipo(((EditText) findViewById(R.id.edtTxtNome)).getText().toString());

        //inserir no BD
        CoffeeDAO.gravar(coffee);

        //recuperar todos para exibir na lista
        ArrayList<Coffee> coffeeList = CoffeeDAO.recuperarTodos();
        ArrayList<String> coffeeListDetalhado = new ArrayList<String>();

        for (Coffee f : coffeeList) {
            coffeeListDetalhado.add("Tipo: " + f.getTipo() + " - Data: " + f.getData());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, coffeeListDetalhado);
        listView.setAdapter(arrayAdapter);

    }
}