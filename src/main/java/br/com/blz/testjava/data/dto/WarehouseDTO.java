package br.com.blz.testjava.data.dto;

import br.com.blz.testjava.data.enums.WarehouseTypeEnum;

public class WarehouseDTO {
    private String locality;
    private Integer quantity;
    private WarehouseTypeEnum type;

    public WarehouseDTO() {
    }

    public WarehouseDTO(String locality, Integer quantity, WarehouseTypeEnum type) {
        this.locality = locality;
        this.quantity = quantity;
        this.type = type;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public WarehouseTypeEnum getType() {
        return type;
    }

    public void setType(WarehouseTypeEnum type) {
        this.type = type;
    }
}
