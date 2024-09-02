package br.com.blz.testjava.data.response;

import java.util.List;

public class InventoryResponse {
    private Integer quantity;
    private List<WarehouseResponse> warehouses;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<WarehouseResponse> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehouseResponse> warehouses) {
        this.warehouses = warehouses;
    }
}
