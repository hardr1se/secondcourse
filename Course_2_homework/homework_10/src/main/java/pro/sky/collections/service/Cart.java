package pro.sky.collections.service;

import org.springframework.stereotype.Component;

import java.util.TreeSet;

@Component
public class Cart {
    TreeSet<Integer> cart;

    public Cart() {
        this.cart = new TreeSet<>();
    }

    public TreeSet<Integer> getCart() {
        return cart;
    }

    public void addToCart(Integer idOrder) {
        cart.add(idOrder);
    }
}
