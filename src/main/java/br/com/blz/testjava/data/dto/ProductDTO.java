package br.com.blz.testjava.data.dto;


public class ProductDTO {

    private String name;
    private InventoryDTO inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InventoryDTO getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDTO inventory) {
        this.inventory = inventory;
    }
}
