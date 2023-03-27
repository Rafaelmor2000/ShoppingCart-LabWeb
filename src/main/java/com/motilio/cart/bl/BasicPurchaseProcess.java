package com.motilio.cart.bl;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.motilio.cart.dl.*;
import com.motilio.cart.domain.*;


@Component
public class BasicPurchaseProcess implements PurchaseProcess {
 
    // Repositories
    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;

    private Customer customer;
    private ShoppingCart shoppingCart;

    public BasicPurchaseProcess() {
        this.customerRepository = new CustomerDatabase();
        this.itemRepository = new ItemDatabase();
        this.shoppingCart = new ShoppingCart();
    }

    @Override
    public Hashtable<Item, BigDecimal> getCartItems(){
        Hashtable<Item, BigDecimal> items = this.shoppingCart.getItems();
        return items;
    }

    @Override
    public void AddItemToCart(Integer itemId, BigDecimal quantity) {
        var item = itemRepository.findItem(itemId);
        this.shoppingCart.AddItemToCart(item, quantity);
    }

    @Override
    public void RemoveItemFromCart(Integer itemId, BigDecimal quantity) {
        if (quantity.compareTo(BigDecimal.ZERO) == 0) {
            return;
        } 
        
        var currentQuantity = this.shoppingCart.GetItemQuantity(itemRepository.findItem(itemId));
        if (currentQuantity.compareTo(quantity) <= 0) {
            this.shoppingCart.RemoveItemFromCart(itemRepository.findItem(itemId));
        } else if (currentQuantity.compareTo(quantity) > 0) {
            this.shoppingCart.UpdateItemInCart(itemRepository.findItem(itemId), currentQuantity.subtract(quantity));
        } 
    }

    @Override
    public BigDecimal getTotal(){
        BigDecimal total = this.shoppingCart.getTotal();
        return total;
    }

    @Override
    public void Checkout() {
        System.out.println("Checking out...");
        System.out.println("Customer: " + this.customer.email());
        System.out.println("Total: " + this.shoppingCart.getTotal());
    }

    @Override
    public Customer setCustomer(int customerId) {
        this.customer = customerRepository.findCustomer(customerId);
        return this.customer;
    }

    @Override
    public Customer getCustomer() {
       return this.customer;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: " + this.customer.email()+"\n");
        var items = this.shoppingCart.getItems();
        
        items.forEach((key, value) -> {
            sb.append("Item: " + key.toString() + " Quantity: " + value + "\n");
        });

        return sb.toString();
    }

    public Map<Integer, Item> getInventory(){
        return itemRepository.getInventory();
    }

}
