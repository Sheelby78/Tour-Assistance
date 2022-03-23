package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    public Inventory (String name, int quantityMax, int quantityNow, List<Realizacja> propozycje){
        this.name = name;
        this.quantityMax = quantityMax;
        this.quantityNow = quantityNow;
    }

    public String getName() {
        return name;
    }

    private String name;

    public int getQuantityMax() {
        return quantityMax;
    }

    private int quantityMax;

    public int getQuantityNow() {
        return quantityNow;
    }

    private int quantityNow;

    public List<Realizacja> getPropozycje() {
        return propozycje;
    }

    private List<Realizacja> propozycje = new ArrayList<>();
}
