package com.coffee.coffeelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import br.com.coffee.dao.CoffeeDAO;

public class DashboardActivity extends AppCompatActivity {

    // MUNO ORDEM
    protected static final int MENU1 = 1;
    protected static final int SUBMENU = 2;
    protected static final int SUBMENU1 = 21;
    protected static final int SUBMENU2 = 22;
    protected static final int SUBMENU3 = 23;
    protected static final int MENU3 = 3;
    protected static final int MENU4 = 4;

    // COMPONENTES VIEW
    private TextView textTotalCooffees;
    private TextView textTotalCooffeesHoje;
    private TextView textTotalLitros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        textTotalCooffees = (TextView) findViewById(R.id.tv_total_coffees);
        textTotalCooffeesHoje = (TextView) findViewById(R.id.tv_total_coffees_hoje);
        textTotalLitros = (TextView) findViewById(R.id.tv_total_coffees_litros);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // cria uma opção para o menu
        // menu.add(grupo para o item de menu, indice do item do menu, ordem de exibicao, titulo para o menu)
        menu.add(0, MENU1, 0, "Registro");

        // cria um sub menu
        SubMenu sub = menu.addSubMenu(0, 0, SUBMENU, "Historico");
        sub.add(0, SUBMENU1, 0, "Hoje");
        sub.add(0, SUBMENU2, 1, "Semana");
        sub.add(0, SUBMENU3, 2, "Todos");
        menu.add(0, MENU3, 4, "Mapa do Café");
        menu.add(0, MENU4, 4, "Sair");

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();

        switch (i) {
            case MENU1:
                Intent registrarCafe = new Intent(DashboardActivity.this, RegistrarCafeActivity.class);
                registrarCafe.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(registrarCafe);
                break;
            case SUBMENU1:
                Intent historicoHoje = new Intent(DashboardActivity.this, HistoricoActivity.class);
                historicoHoje.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(historicoHoje);
                break;
            case SUBMENU2:
                Intent historicoSemana = new Intent(DashboardActivity.this, HistoricoActivity.class);
                historicoSemana.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(historicoSemana);
                break;
            case SUBMENU3:
                Intent historicoTotal = new Intent(DashboardActivity.this, HistoricoActivity.class);
                historicoTotal.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(historicoTotal);
                break;
            case MENU3:
                Intent mapaCafe = new Intent(DashboardActivity.this, MapsActivity.class);
                mapaCafe.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(mapaCafe);
                break;
            case MENU4:
                System.exit(0);
                break;
        }

        return false;

    }

    @Override
    protected void onResume() {
        super.onResume();
        totalCoffees();
        totalCoffeesHoje();
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