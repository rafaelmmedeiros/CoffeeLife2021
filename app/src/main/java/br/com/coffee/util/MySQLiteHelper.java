package br.com.coffee.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    // definir o nome da base de dados para BD_coffeelife.db
    private static final String DATABASE_NAME = "BD_coffeelife.db";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create tb_coffees table
        String sqlCreateTableTbcoffees =
                "CREATE TABLE IF NOT EXISTS tb_coffees ("
                        + "pk_coffee integer PRIMARY KEY AUTOINCREMENT,"
                        + "tipo varchar(70) NOT NULL,"
                        + "created_at TIMESTAMP default current_timestamp);";

        // create tb_coffees table
        db.execSQL(sqlCreateTableTbcoffees);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
