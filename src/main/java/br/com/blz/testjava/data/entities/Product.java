package br.com.blz.testjava.data.entities;

import br.com.blz.testjava.data.request.InventoryRequest;

import java.util.Objects;

public class Product {
    private String name;
    private Inventory inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
