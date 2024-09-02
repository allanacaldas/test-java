package br.com.blz.testjava.data.request;

import javax.validation.constraints.NotNull;
import java.util.List;

public class InventoryRequest {

    @NotNull
    private List<WarehouseRequest> warehouses;

    public List<WarehouseRequest> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<WarehouseRequest> warehouses) {
        this.warehouses = warehouses;
    }
}
