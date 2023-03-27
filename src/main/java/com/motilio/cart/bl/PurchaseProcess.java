package com.motilio.cart.bl;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;

import com.motilio.cart.domain.*;

public interface PurchaseProcess {
    
    public void AddItemToCart(Integer itemId, BigDecimal quantity);

    public void RemoveItemFromCart(Integer itemId, BigDecimal quantity);

    public Hashtable<Item, BigDecimal> getCartItems();

    public BigDecimal getTotal();

    public void Checkout();

    public Customer setCustomer(int customerId);

    public Customer getCustomer();

    public Map<Integer, Item> getInventory();

}
