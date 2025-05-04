package org.example.tp3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductApiClient productApiClient;

    @InjectMocks
    private ProductService productService;

    @Test
    void testGetProductSuccess() {
        Product mockProduct = new Product("123", "Smartphone");
        when(productApiClient.getProduct("123")).thenReturn(mockProduct);

        Product result = productService.getProduct("123");

        assertNotNull(result);
        assertEquals("123", result.getId());
        assertEquals("Smartphone", result.getName());
        verify(productApiClient).getProduct("123");
    }

    @Test
    void testGetProductReturnsNull() {
        when(productApiClient.getProduct("000")).thenReturn(null);

        Product result = productService.getProduct("000");

        assertNull(result);
        verify(productApiClient).getProduct("000");
    }

    @Test
    void testGetProductThrowsException() {
        when(productApiClient.getProduct("error")).thenThrow(new RuntimeException("API failure"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            productService.getProduct("error");
        });

        assertEquals("API failure", exception.getMessage());
        verify(productApiClient).getProduct("error");
    }
}
