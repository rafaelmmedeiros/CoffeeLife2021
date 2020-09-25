package br.com.coffee.model;

public class Coffee {
    private int pk_coffee;
    private String tipo;

    public Coffee() {

    }

    public Coffee(String _tipo) {
        this.tipo = _tipo;
    }

    public Coffee(int _pk_coffee, String _tipo) {
        this.pk_coffee = _pk_coffee;
        this.tipo = _tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPk_coffee() {
        return pk_coffee;
    }

    public void setPk_coffee(int pk_coffee) {
        this.pk_coffee = pk_coffee;
    }

}



