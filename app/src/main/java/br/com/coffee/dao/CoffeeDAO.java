package br.com.coffee.dao;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import br.com.coffee.model.Coffee;
import br.com.coffee.util.MySQLiteHelper;

public class CoffeeDAO {
    private SQLiteDatabase db = null;
    private MySQLiteHelper mySQLiteHelper = null;

    public CoffeeDAO(Context context) {
        mySQLiteHelper = new MySQLiteHelper(context);
    }

    public long gravar(Coffee coffee) throws SQLException {
        // 1. recupera a referencia do db
        this.db = mySQLiteHelper.getWritableDatabase();

        // 2. preparar uma ContentValues com os parametros para insert
        ContentValues contentValues = new ContentValues();
        contentValues.put("tipo", coffee.getTipo());

        // 3. realizar o insert
        long retorno = db.insert("tb_coffees", null, contentValues);

        // 4. fechar o banco e dar o retorno
        db.close();
        return retorno;
    }

    public ArrayList<Coffee> recuperarTodos() {
        ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

        // 1. construir a query
        String query = "SELECT  * FROM tb_coffees";

        // 2. recupera a referencia do db
        this.db = mySQLiteHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. para cada registro, transformar em objeto (do tipo Coffee) e
        // adicionar a lista
        if (cursor.moveToFirst()) {
            do {
                Coffee coffee = new Coffee();
                coffee.setPk_coffee(Integer.parseInt(cursor.getString(0)));
                coffee.setTipo(cursor.getString(1));

                // 3.1. adicionar o func a lista de funcionarios
                coffeeList.add(coffee);
            } while (cursor.moveToNext());
        }

        // 4. fechar o banco e dar o retorno
        db.close();
        return coffeeList;
    }

}

