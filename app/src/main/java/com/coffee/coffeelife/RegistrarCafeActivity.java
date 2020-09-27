package com.coffee.coffeelife;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

import br.com.coffee.dao.CoffeeDAO;
import br.com.coffee.model.Coffee;

public class RegistrarCafeActivity extends AppCompatActivity {

    protected AlertDialog.Builder mensagem;
    MediaPlayer clickSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cafe);

        mensagem = new AlertDialog.Builder(this);
        clickSound = MediaPlayer.create(this, R.raw.click);
    }

    public void registrarCoffeeTradicional(View v) {

        Coffee coffee = new Coffee();
        CoffeeDAO CoffeeDAO = new CoffeeDAO(this);

        coffee.setTipo("Tradicional");
        CoffeeDAO.gravar(coffee);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        clickSound.start();

        mensagem.setTitle("Sucesso!");
        mensagem.setMessage("Café Tradicional Registrado.");
        mensagem.setNeutralButton("OK", null);

        mensagem.show();
    }

    public void registrarCoffeeLeite(View v) {

        Coffee coffee = new Coffee();
        CoffeeDAO CoffeeDAO = new CoffeeDAO(this);

        coffee.setTipo("Café com Leite");
        CoffeeDAO.gravar(coffee);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        clickSound.start();

        mensagem.setTitle("Sucesso!");
        mensagem.setMessage("Café com Leite Registrado.");
        mensagem.setNeutralButton("OK", null);

        mensagem.show();
    }

    public void registrarCoffeeExpresso(View v) {

        Coffee coffee = new Coffee();
        CoffeeDAO CoffeeDAO = new CoffeeDAO(this);

        coffee.setTipo("Expresso");
        CoffeeDAO.gravar(coffee);

        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        clickSound.start();

        mensagem.setTitle("Sucesso!");
        mensagem.setMessage("Café Expresso Registrado.");
        mensagem.setNeutralButton("OK", null);

        mensagem.show();
    }

}