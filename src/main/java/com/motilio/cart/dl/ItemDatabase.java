package com.motilio.cart.dl;

import java.math.BigDecimal;
import java.util.Map;

import com.motilio.cart.domain.*;

public class ItemDatabase implements ItemRepository {
    
    private Map<Integer, Item> items = Map.of(
        1, new Item(1, "Tomate", "Tomate Huaje", new BigDecimal(43.0)),
        2, new Item(2, "Papa", "Papa Blanca", new BigDecimal(24.0)),
        3, new Item(3, "Cebolla", "Cebolla Morada", new BigDecimal(15.0)),
        4, new Item(4, "Chile", "Chile Serrano", new BigDecimal(43.0))
    );

    @Override
    public Item findItem(int itemId) {
       return items.get(itemId);
    }

    @Override
    public BigDecimal findItemInventory(int itemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findItemInventory'");
    }

    @Override
    public Item addItem(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    @Override
    public Item updateItem(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateItem'");
    }

    @Override
    public Item deleteItem(int itemId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteItem'");
    }

    @Override
    public Map<Integer, Item> getInventory(){
        return items;
    }
}
