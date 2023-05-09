package pro.sky.collections.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.collections.service.CartService;

@RequestMapping("/order")
@RestController
public class CustomerOrderController {
    private final CartService cartService;

    public CustomerOrderController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add")
    public String addOrder(@RequestParam(value = "orderId", required = false)String orderId) {
        return cartService.addOrder(orderId);
    }

    @GetMapping("/get")
    public String getOrder() {
        return cartService.getOrder();
    }

    @ExceptionHandler
    public String illegalArgumentExceptionHandler(IllegalArgumentException e) {
        return "Вы неверно ввели значение";
    }
}
