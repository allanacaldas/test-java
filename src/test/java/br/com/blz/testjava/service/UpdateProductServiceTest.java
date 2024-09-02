package br.com.blz.testjava.service;

import br.com.blz.testjava.data.entities.Product;
import br.com.blz.testjava.exception.DuplicatedProductException;
import br.com.blz.testjava.exception.ProductNotFoundException;
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
class UpdateProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private UpdateProductService updateProductService;

    @Test
    public void shouldUpdateProductSuccessfully() {
        when(repository.update(anyLong(), any(Product.class))).thenReturn(getProduct());

        var expectedOutPut =  getProductOutputDTO();
        var actualOutput = updateProductService.update(SKU,getProductDTO());

        assertEquals(expectedOutPut.getName(),actualOutput.getName());
        assertEquals(expectedOutPut.getSku(),actualOutput.getSku());
        assertEquals(expectedOutPut.getInventory().getWarehouses().size(),
            actualOutput.getInventory().getWarehouses().size());

        verify(repository, times(1)).update(anyLong(), any(Product.class));
    }

    @Test
    public void shouldThrowProductNotFoundExceptionWhenRepeatProduct() {
        when(repository.update(anyLong(), any(Product.class))).thenReturn(null);
        assertThrows(ProductNotFoundException.class, () -> updateProductService.update(SKU,getProductDTO()));
        verify(repository, times(1)).update(anyLong(), any(Product.class));
    }
}
