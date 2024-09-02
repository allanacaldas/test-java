package br.com.blz.testjava.data.dto;


public class ProductOutputDTO {

    private Long sku;
    private String name;
    private InventoryDTO inventory;
    private Boolean isMarketable;


    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

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

    public Boolean getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(Boolean marketable) {
        isMarketable = marketable;
    }
}
