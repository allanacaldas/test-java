package br.com.blz.testjava.data.dto;

import java.util.List;

public class InventoryDTO {
    private Integer quantity;
    private List<WarehouseDTO> warehouses;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<WarehouseDTO> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehouseDTO> warehouses) {
        this.warehouses = warehouses;
    }
}
