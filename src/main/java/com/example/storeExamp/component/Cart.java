package com.example.storeExamp.component;

import com.example.storeExamp.dto.OrderItem;
import com.example.storeExamp.model.Item;
import com.example.storeExamp.repository.ItemRepository;
import com.example.storeExamp.service.ItemService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@SessionScope
public class Cart {
    private  Map<Long, OrderItem> content;
    private Integer totalPrice;
    private final ItemService service;

    public Cart(ItemService service){
        this.content = new HashMap<>();
        this.totalPrice = totalPrice;
        this.service = service;
    }

    public void addCart(Long id){
        Item item = service.getById(id);
        if (content == null){
            content = new HashMap<>();
        }
        if (!content.containsKey(item.getId())){
            Integer quantity = 1;
            content.put(item.getId(), new OrderItem(id, item.getName(), item.getPrice(), quantity ));
        } else {
            content.get(id).setQuantity(content.get(id).getQuantity()+1);
        }
    }
    public void subCart(Long id){
        if (content.isEmpty()){
            System.out.println( "The cart is empty");
        }else if (!content.containsKey(id)) {
            System.out.println( "Product is not in the cart");
        } else {
            content.get(id).setQuantity(content.get(id).getQuantity()-1);
            if (content.get(id).getQuantity() == 0) {
                content.remove(id);
            }
        }
    }
    public Integer fullCartPrice() {
        Integer summ = 100000;

        if (content == null) {
            return summ;
        } else {
            for (Map.Entry<Long, OrderItem> pair : content.entrySet()) {
                summ = summ + pair.getValue().getPrice() * pair.getValue().getQuantity();
            }
            return summ;
        }
    }
    public List<OrderItem> findAll(){
        if (content == null) {
            return null;
        }
        return new ArrayList<OrderItem>(content.values());
    }
}
