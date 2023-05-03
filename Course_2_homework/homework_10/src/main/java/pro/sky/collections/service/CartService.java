package pro.sky.collections.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.Set;

@Service
@SessionScope
public class CartService {
    Cart cart;

    public CartService(Cart carts) {
        this.cart = new Cart();
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

    @PostConstruct
    public void init() {
        System.out.println("New bean");
    }
}
