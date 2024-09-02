package br.com.blz.testjava.service;

import br.com.blz.testjava.data.dto.ProductOutputDTO;
import br.com.blz.testjava.data.entities.Product;
import br.com.blz.testjava.exception.ProductNotFoundException;
import br.com.blz.testjava.mapper.ProductMapper;
import br.com.blz.testjava.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.blz.testjava.utils.Util.*;

@Service
public class FindProductService {

    private final ProductRepository productRepository;

    public FindProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductOutputDTO getBySku(Long sku) {
        Product product = Optional.ofNullable(productRepository.findBySku(sku))
            .orElseThrow(() -> new ProductNotFoundException(buildNotFoundErrorMessage(sku)));

        var sumInventoryItems = calculateInventory(convertList(product.getInventory().getWarehouses()));
        var isMarketable = checkStockAvailability(sumInventoryItems);
        return ProductMapper.INSTANCE.toOutputDTO(product, isMarketable, sumInventoryItems, sku);
    }

}
