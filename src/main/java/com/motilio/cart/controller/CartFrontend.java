package com.motilio.cart.controller;



import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.motilio.cart.bl.*;
import com.motilio.cart.domain.*;

@Controller
public class CartFrontend {
    static private PurchaseProcess purchaseProcess;


    @GetMapping("/cart")
    public String cart(Model model) {
        if (purchaseProcess == null){
            return "redirect:/cart/new";
        }
        
        
        Hashtable<Item, BigDecimal> items = purchaseProcess.getCartItems();
        BigDecimal total = purchaseProcess.getTotal();

        model.addAttribute("items", items);
        model.addAttribute("title", "Carrito de compras");
        model.addAttribute("total", total);
        return "cart";
    }

    @GetMapping("/cart/new")
    public String cartNew(Model model){
        if (purchaseProcess == null){
            purchaseProcess = new BasicPurchaseProcess();
        }
        
        Hashtable<Item, BigDecimal> items = purchaseProcess.getCartItems();
        BigDecimal total = purchaseProcess.getTotal();

        model.addAttribute("items", items);
        model.addAttribute("title", "Nuevo carrito de compras");
        model.addAttribute("total", total);
        return "cart";
    }

    @GetMapping("/cart/retirar")
    public String retirar(@RequestParam(name = "action") String value, Model model){
        BigDecimal quantity = new BigDecimal(1);
        Integer id = Integer.valueOf(value);
        System.out.println("Se retiró la id "+id);
        purchaseProcess.RemoveItemFromCart(id, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/cart/agregar")
    public String agregar(@RequestParam(name = "action") String value, Model model){
        BigDecimal quantity = new BigDecimal(1);
        Integer id = Integer.valueOf(value);
        System.out.println("Se retiró la id "+id);
        purchaseProcess.AddItemToCart(id, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/inventory")
    public String inventory(Model model){
        if (purchaseProcess == null){
            return "redirect:/cart";
        }
        Map<Integer, Item> products = purchaseProcess.getInventory();

        model.addAttribute("items", products);
        model.addAttribute("title", "Productos disponibles");
        return "inventory";
    }

    @GetMapping("/inventory/addItems")
    public String addFromInventory(@RequestParam(name = "action") String _value,@RequestParam(name = "quantity") String _quantity, Model model){
        if (purchaseProcess == null){
            return "redirect:/cart";
        }
        Map<Integer, Item> products = purchaseProcess.getInventory();
        Integer id = Integer.valueOf(_value);
        Integer qu = Integer.valueOf(_quantity);
        BigDecimal quantity = new BigDecimal(qu);
        String message;
        if(qu > 0){
            purchaseProcess.AddItemToCart(id, quantity);
            Item item = products.get(id);
            if(qu>1){
                message = quantity + " " + item.name() + "s han sido añadid@s";
            }
            else{
                message = quantity + " " + item.name() + " ha sido añadid@";
            }
        }
        else{
            message = "La cantidad debe ser mayor a 0";
        }

        model.addAttribute("message", message);
        model.addAttribute("items", products);
        model.addAttribute("title", "Productos disponibles");
        return "inventory";
    }
}
