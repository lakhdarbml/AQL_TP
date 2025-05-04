package org.example.tp3;

public class OrderService {

    private final OrderDao orderDao;

    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void createOrder(Order order) {
        orderDao.saveOrder(order);
    }
}
