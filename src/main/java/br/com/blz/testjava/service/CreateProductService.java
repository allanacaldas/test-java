package br.com.blz.testjava.service;

import br.com.blz.testjava.data.dto.ProductDTO;
import br.com.blz.testjava.data.dto.ProductOutputDTO;
import br.com.blz.testjava.data.entities.Product;
import br.com.blz.testjava.exception.DuplicatedProductException;
import br.com.blz.testjava.mapper.ProductMapper;
import br.com.blz.testjava.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.blz.testjava.utils.Util.*;

@Service
public class CreateProductService {

    private final ProductRepository productRepository;

    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductOutputDTO create(ProductDTO productDTO, Long sku) {

        var sumInventoryItems = calculateInventory(productDTO.getInventory().getWarehouses());
        var isMarketable = checkStockAvailability(sumInventoryItems);
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);

        Optional.ofNullable(productRepository.save(sku,product))
                    .ifPresent(existingProduct -> {
                        throw new DuplicatedProductException(DUPLICATED_PRODUCT_ERROR_MESSAGE);
                    });

        return ProductMapper.INSTANCE.toOutputDTO(product, isMarketable, sumInventoryItems, sku);
    }
}
