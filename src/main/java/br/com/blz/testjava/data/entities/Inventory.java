package br.com.blz.testjava.data.entities;

import java.util.List;

public class Inventory {

    private List<Warehouse> warehouses;

    public List<Warehouse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<Warehouse> warehouses) {
        this.warehouses = warehouses;
    }
}
