package br.com.blz.testjava.service;

import br.com.blz.testjava.exception.ProductNotFoundException;
import br.com.blz.testjava.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static br.com.blz.testjava.utils.Util.buildNotFoundErrorMessage;

@Service
public class DeleteProductService {

    private final ProductRepository productRepository;

    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void delete(Long sku) {
        Optional.ofNullable(productRepository.delete(sku))
            .orElseThrow(() -> new ProductNotFoundException(buildNotFoundErrorMessage(sku)));
    }
}
