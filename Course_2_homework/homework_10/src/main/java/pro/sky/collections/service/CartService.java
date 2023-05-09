package pro.sky.collections.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Set;

@Service
public class CartService {
    private final Cart cart;

    public CartService(Cart cart) {
        this.cart = cart;
    }

    public String addOrder(String orderId) {
        if (StringUtils.isNumeric(orderId) || orderId == null) {
            throw new IllegalArgumentException();
        }
        Arrays.stream(orderId.split(",")).forEach(x -> cart.addToCart(Integer.parseInt(x.trim())));
        return "Значения успешно добавлены";
    }

    public String getOrder() {
        Set<Integer> orders = cart.getCart();
        if (orders.isEmpty()) {
            return "Ваша корзина еще пуста";
        } else {
            return orders.toString();
        }
    }
}
