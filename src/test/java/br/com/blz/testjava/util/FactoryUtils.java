package br.com.blz.testjava.util;

import br.com.blz.testjava.data.dto.InventoryDTO;
import br.com.blz.testjava.data.dto.ProductDTO;
import br.com.blz.testjava.data.dto.ProductOutputDTO;
import br.com.blz.testjava.data.dto.WarehouseDTO;
import br.com.blz.testjava.data.entities.Inventory;
import br.com.blz.testjava.data.entities.Product;
import br.com.blz.testjava.data.entities.Warehouse;
import br.com.blz.testjava.data.enums.WarehouseTypeEnum;
import br.com.blz.testjava.data.request.CreateProductRequest;
import br.com.blz.testjava.data.request.InventoryRequest;
import br.com.blz.testjava.data.request.UpdateProductRequest;

import java.util.List;

public class FactoryUtils {
    public static final Long SKU = 123456L;
    public static final Integer QUANTITY = 100;
    public static final String PRODUCT_NAME = "MALBEC NOIR";
    public static final String LOCALITY = "Recife";


    private FactoryUtils() {
    }

    public static ProductDTO getProductDTO() {
        var productDTO = new ProductDTO();
        productDTO.setName(PRODUCT_NAME);
        productDTO.setInventory(getInventoryDTO());
        return productDTO;

    }

    public static InventoryDTO getInventoryDTO() {
        var inventoryDTO = new InventoryDTO();
        inventoryDTO.setWarehouses(List.of(getWarehouseDTO()));
        return inventoryDTO;

    }

    public static WarehouseDTO getWarehouseDTO() {
        return new WarehouseDTO(LOCALITY, QUANTITY, WarehouseTypeEnum.ECOMMERCE);
    }

    public static Product getProduct() {
        var product = new Product();
        product.setName(PRODUCT_NAME);
        product.setInventory(getInventory());
        return product;

    }

    public static Inventory getInventory() {
        var inventory = new Inventory();
        inventory.setWarehouses(List.of(getWarehouse()));
        return inventory;

    }

    public static Warehouse getWarehouse() {
        var warehouse = new Warehouse();
        warehouse.setLocality(LOCALITY);
        warehouse.setQuantity(QUANTITY);
        warehouse.setType(WarehouseTypeEnum.ECOMMERCE);
        return warehouse;
    }

    public static ProductOutputDTO getProductOutputDTO() {
        var outputDTO = new ProductOutputDTO();
        outputDTO.setSku(SKU);
        outputDTO.setIsMarketable(Boolean.TRUE);
        outputDTO.setName(PRODUCT_NAME);
        outputDTO.setInventory(getInventoryDTO());
        return outputDTO;

    }

    public static CreateProductRequest getCreateProductRequest() {
        var createProductRequest = new CreateProductRequest();
        createProductRequest.setName(PRODUCT_NAME);
        createProductRequest.setSku(SKU);
        createProductRequest.setInventory(new InventoryRequest());
        return createProductRequest;
    }

    public static UpdateProductRequest getUpdateProductRequest() {
        var updateProductRequest = new UpdateProductRequest();
        updateProductRequest.setName(PRODUCT_NAME);
        updateProductRequest.setInventory(new InventoryRequest());
        return updateProductRequest;
    }

}
