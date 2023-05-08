package pro.sky.java.course2.teststore.model;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Repository
@SessionScope
public class Basket {

    @PostConstruct
    public void init(){
        System.out.println("Корзина создана.");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Корзина удалена.");
    }

    private final List<Product> basketList = new ArrayList<>();

    public void add(Product product) {
        basketList.add(product);
    }

    public List<Product> getBasketList() {
        return List.copyOf(basketList);
    }
}
