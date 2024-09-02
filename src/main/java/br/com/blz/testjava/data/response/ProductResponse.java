package br.com.blz.testjava.data.response;

public class ProductResponse {
    private Long sku;
    private String name;
    private InventoryResponse inventory;
    private Boolean isMarketable;

    public Boolean getIsMarketable() {
        return isMarketable;
    }

    public void setIsMarketable(Boolean marketable) {
        isMarketable = marketable;
    }

    public InventoryResponse getInventory() {
        return inventory;
    }

    public void setInventory(InventoryResponse inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }
}
