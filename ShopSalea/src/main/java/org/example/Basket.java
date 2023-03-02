package org.example;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    Map<String, Product> products = new HashMap<String, Product>();

    public Basket() {}

    public boolean add(Product product) {
        if (product.isEmpty())
            return false;
        if (products.containsKey(product.getName())) {
            Product old = products.get(product.getName());
            old.setAmount(old.getAmount() + product.getAmount());
            products.replace(product.getName(), old);
        } else
            products.put(product.getName(), product);
        return true;
    }

    public boolean remove(Product product) {
        if (product.isEmpty())
            return false;
        if (products.containsKey(product.getName())) {
            Product old = products.get(product.getName());
            int diff = old.getAmount() - product.getAmount();
            old.setAmount((diff >= 0) ? diff : 0);
            if (old.getAmount() != 0)
                products.replace(product.getName(), old);
            else
                products.remove(product.getName());
            return true;
        } else
            return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("\n");
        int i = 1;
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            Product value = entry.getValue();
            sb.append(i).append(". ")
                    .append(value.getName())
                    .append(", количество: ")
                    .append(value.getAmount())
                    .append("\n");
            i++;
        }
        return sb.toString();
    }
}