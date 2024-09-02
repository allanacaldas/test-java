package br.com.blz.testjava.utils;

import br.com.blz.testjava.data.dto.WarehouseDTO;
import br.com.blz.testjava.data.entities.Warehouse;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Util {

    public static final String PRODUCT_NOT_FOUND_ERROR_MESSAGE = "Produto sku n.%d não encontrado";
    public static final String DUPLICATED_PRODUCT_ERROR_MESSAGE = "Produtos repetidos não podem ser adicionados ao estoque.";


    public static Integer calculateInventory(List<WarehouseDTO> warehouseList) {
        return Objects.nonNull(warehouseList) ? warehouseList.stream().mapToInt(WarehouseDTO::getQuantity).sum() : 0;
    }

    public static Boolean checkStockAvailability(Integer quantity) {
        return quantity > 0;
    }

    public static String buildNotFoundErrorMessage(Long sku) {
        return String.format(PRODUCT_NOT_FOUND_ERROR_MESSAGE, sku);
    }

    public static List<WarehouseDTO> convertList(List<Warehouse> warehouseList) {

        return warehouseList.stream()
            .map(warehouse -> new WarehouseDTO(
                warehouse.getLocality(),
                warehouse.getQuantity(),
                warehouse.getType()
            ))
            .collect(Collectors.toList());
    }
}
