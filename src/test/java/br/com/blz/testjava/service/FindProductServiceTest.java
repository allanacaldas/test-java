package br.com.blz.testjava.service;

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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private FindProductService findProductService;

    @Test
    public void shouldRetrieveProductSuccessfully() {
        when(repository.findBySku(anyLong())).thenReturn(getProduct());

        var expectedOutput = getProductOutputDTO();
        var actualOutput = findProductService.getBySku(SKU);

        assertEquals(expectedOutput.getName(),actualOutput.getName());
        assertEquals(expectedOutput.getSku(),actualOutput.getSku());
        assertEquals(expectedOutput.getInventory().getWarehouses().size(),
            actualOutput.getInventory().getWarehouses().size());

        verify(repository, times(1)).findBySku(anyLong());
    }

    @Test
    public void shouldThrowProductNotFoundException() {
        when(repository.findBySku(anyLong())).thenReturn(null);
        assertThrows(ProductNotFoundException.class, () -> findProductService.getBySku(SKU));
        verify(repository, times(1)).findBySku(anyLong());
    }
}
