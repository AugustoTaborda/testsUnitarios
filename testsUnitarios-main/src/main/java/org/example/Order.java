package org.example;

import java.util.ArrayList;
import java.util.List;

class Order {
    private final List<String> items = new ArrayList<>();
    private boolean paid;

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    public void pay() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cannot pay for an empty order");
        }
        paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public Order(boolean paid) {
        this.paid = paid;
    }

    public Order() {
    }
}