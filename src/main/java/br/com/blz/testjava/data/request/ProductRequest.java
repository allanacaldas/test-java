package br.com.blz.testjava.data.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public abstract class ProductRequest {

    @NotBlank(message = "O campo 'name' é obrigatório")
    private String name;

    @NotNull(message = "O campo 'inventory' é obrigatório")
    private InventoryRequest inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InventoryRequest getInventory() {
        return inventory;
    }

    public void setInventory(InventoryRequest inventory) {
        this.inventory = inventory;
    }
}
