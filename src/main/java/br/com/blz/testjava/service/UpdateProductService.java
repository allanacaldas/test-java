package br.com.blz.testjava.service;

import br.com.blz.testjava.data.dto.ProductDTO;
import br.com.blz.testjava.data.dto.ProductOutputDTO;
import br.com.blz.testjava.data.entities.Product;
import br.com.blz.testjava.exception.ProductNotFoundException;
import br.com.blz.testjava.mapper.ProductMapper;
import br.com.blz.testjava.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.blz.testjava.utils.Util.*;

@Service
public class UpdateProductService {

    private final ProductRepository productRepository;

    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductOutputDTO update(Long sku, ProductDTO productDTO) {

        var sumInventoryItems = calculateInventory(productDTO.getInventory().getWarehouses());
        var isMarketable = checkStockAvailability(sumInventoryItems);
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);

        Optional.ofNullable(productRepository.update(sku, product))
            .orElseThrow(() -> new ProductNotFoundException(buildNotFoundErrorMessage(sku)));

        return ProductMapper.INSTANCE.toOutputDTO(product, isMarketable, sumInventoryItems, sku);
    }
}
