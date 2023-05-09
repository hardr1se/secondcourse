package pro.sky.collections.service;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.TreeSet;

@Component
@SessionScope
public class Cart {
    private final TreeSet<Integer> cart;

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
