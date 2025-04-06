package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    private Order order;

    // -> Intancia antes de executar todos os tests
    @BeforeEach
    void setUp() {
        order = new Order();
    }

    @Test
    void testAdicionaNaLista() {
        order.addItem("Pizza");
        assertTrue(order.getItems().contains("Pizza"));
    }

    @Test
    void testRemoveDaLista() {
        order.addItem("Sushi");
        order.removeItem("Sushi");
        assertFalse(order.getItems().contains("Sushi"));
    }

    @Test
    void testPagamentoComItens() {
        order.addItem("Burger");
        order.pay();
        assertTrue(order.isPaid());
    }

    @Test
    void testPagamentoComListaVazia() {
        Exception exception = assertThrows(IllegalStateException.class, order::pay);
        assertEquals("Cannot pay for an empty order", exception.getMessage());
    }

    @Test
    void testInicialNaoPago() {
        assertFalse(order.isPaid());
    }

    @Test
    void testSetPaid() {
        order.setPaid(true);
        assertTrue(order.isPaid());
    }
}
