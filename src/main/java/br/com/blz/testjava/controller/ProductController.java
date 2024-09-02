package br.com.blz.testjava.controller;

import br.com.blz.testjava.data.request.CreateProductRequest;
import br.com.blz.testjava.data.request.UpdateProductRequest;
import br.com.blz.testjava.data.response.ProductResponse;
import br.com.blz.testjava.mapper.ProductMapper;
import br.com.blz.testjava.service.DeleteProductService;
import br.com.blz.testjava.service.FindProductService;
import br.com.blz.testjava.service.CreateProductService;
import br.com.blz.testjava.service.UpdateProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
@RequestMapping("/products")
public class ProductController {
    Logger logger = Logger.getLogger(ProductController.class.getName());

    FindProductService findService;
    CreateProductService createService;
    UpdateProductService updateService;
    DeleteProductService deleteService;


    public ProductController(FindProductService findService, CreateProductService createService,
                             UpdateProductService updateService, DeleteProductService deleteService) {
        this.findService = findService;
        this.createService = createService;
        this.updateService = updateService;
        this.deleteService = deleteService;
    }


    @GetMapping("/{sku}")
    public ResponseEntity<ProductResponse> findBySku(@PathVariable Long sku) {
        var response = ProductMapper.INSTANCE.toProductResponse(findService.getBySku(sku));
        return ResponseEntity.ok(response);
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> create(@Valid @RequestBody CreateProductRequest request) {
        var inputDTO = ProductMapper.INSTANCE.toInputDTO(request);
        var outputDTO = createService.create(inputDTO, request.getSku());
        var response = ProductMapper.INSTANCE.toProductResponse(outputDTO);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{sku}")
    public ResponseEntity<String> delete(@PathVariable Long sku) {
        deleteService.delete(sku);
        return ResponseEntity.ok(String.format("Product sku n.%d was successfully deleted", sku));
    }

    @PutMapping("/{sku}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long sku, @Valid @RequestBody UpdateProductRequest request) {
        var inputDTO = ProductMapper.INSTANCE.toInputDTO(request);
        var outputDTO = updateService.update(sku, inputDTO);
        var response = ProductMapper.INSTANCE.toProductResponse(outputDTO);
        return ResponseEntity.ok(response);
    }
}
