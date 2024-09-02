package br.com.blz.testjava.repository;

import br.com.blz.testjava.data.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {

    private HashMap<Long, Product> productsStock = new HashMap<Long, Product>();

    public Product findBySku(Long sku) {
        return productsStock.get(sku);
    }

    public Product delete(Long sku) {
        return productsStock.remove(sku);
    }

    public Product save(Long sku, Product product) {
        return productsStock.putIfAbsent(sku,product);
    }

    public Product update(Long sku, Product product) {
        return productsStock.replace(sku, product);
    }

}
