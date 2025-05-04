package org.example.tp3;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @Test
    void testCreateOrderIntegration() {
        // Mocks
        OrderDao mockDao = mock(OrderDao.class);
        OrderService service = new OrderService(mockDao);
        OrderController controller = new OrderController(service);

        // Order à tester
        Order order = new Order(100, "Ordinateur Portable");

        // Appel du contrôleur
        controller.createOrder(order);

        // Vérification
        verify(mockDao).saveOrder(order);
        verifyNoMoreInteractions(mockDao);
    }
}
