package br.com.blz.testjava.controller;

import br.com.blz.testjava.data.dto.ProductDTO;
import br.com.blz.testjava.service.CreateProductService;
import br.com.blz.testjava.service.DeleteProductService;
import br.com.blz.testjava.service.FindProductService;
import br.com.blz.testjava.service.UpdateProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;


import static br.com.blz.testjava.util.FactoryUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @InjectMocks
    private ProductController controller;
    @Mock
    private FindProductService findService;
    @Mock
    private CreateProductService createService;
    @Mock
    private UpdateProductService updateService;
    @Mock
    private DeleteProductService deleteService;


    @Test
    public void testFindProduct() throws Exception {
        when(findService.getBySku(anyLong())).thenReturn(getProductOutputDTO());
        var response = controller.findBySku(SKU);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testCreateProduct() {
        when(createService.create(any(ProductDTO.class), anyLong()))
            .thenReturn(getProductOutputDTO());
        var response = controller.create(getCreateProductRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testUpdateProduct() {
        when(updateService.update(anyLong(),any(ProductDTO.class)))
            .thenReturn(getProductOutputDTO());
        var response = controller.update(SKU,getUpdateProductRequest());
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Test
    public void testDeleteProduct() {
        doNothing().when(deleteService).delete(anyLong());
        var response = controller.delete(SKU);

        assertEquals( HttpStatus.OK, response.getStatusCode());
        assertEquals(String.format("Product sku n.%d was successfully deleted", SKU),
            response.getBody());

    }


}

