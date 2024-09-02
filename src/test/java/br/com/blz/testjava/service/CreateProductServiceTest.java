package br.com.blz.testjava.service;

import br.com.blz.testjava.data.entities.Product;
import br.com.blz.testjava.exception.DuplicatedProductException;
import br.com.blz.testjava.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.blz.testjava.util.FactoryUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private CreateProductService createProductService;

    @Test
    public void shouldCreateProductSuccessfully() {
        when(repository.save(anyLong(), any(Product.class))).thenReturn(null);
        var expectedOutPut =  getProductOutputDTO();
        var actualOutput = createProductService.create(getProductDTO(), SKU);

        assertEquals(expectedOutPut.getName(),actualOutput.getName());
        assertEquals(expectedOutPut.getSku(),actualOutput.getSku());
        assertEquals(expectedOutPut.getInventory().getWarehouses().size(),
            actualOutput.getInventory().getWarehouses().size());

        verify(repository, times(1)).save(anyLong(), any(Product.class));
    }

    @Test
    public void shouldThrowDuplicatedProductExceptionWhenRepeatProduct() {
        var existingProduct = getProduct();
        when(repository.save(anyLong(), any(Product.class))).thenReturn(existingProduct);
        assertThrows(DuplicatedProductException.class, () -> createProductService.create(getProductDTO(), SKU));
        verify(repository, times(1)).save(anyLong(), any(Product.class));
    }
}
