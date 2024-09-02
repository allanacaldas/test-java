package br.com.blz.testjava.service;

import br.com.blz.testjava.exception.ProductNotFoundException;
import br.com.blz.testjava.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.blz.testjava.util.FactoryUtils.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DeleteProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private DeleteProductService deleteProductService;

    @Test
    public void shouldDeleteProductSuccessfully() {
        when(repository.delete(anyLong())).thenReturn(getProduct());
        deleteProductService.delete(SKU);
        verify(repository, times(1)).delete(anyLong());
    }

    @Test
    public void shouldThrowProductNotFoundException() {
        when(repository.delete(anyLong())).thenReturn(null);
        assertThrows(ProductNotFoundException.class, () -> deleteProductService.delete(SKU));
        verify(repository, times(1)).delete(anyLong());
    }
}
