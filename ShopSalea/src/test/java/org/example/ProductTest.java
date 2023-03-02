package org.example;

import org.junit.jupiter.api.BeforeEach;
import  org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
Product product;
@BeforeEach
void parametrClass(){
     product = new Product("Product",5);
}
    @Test
    void getName() {
 assertEquals("Product",product.getName());
    }

    @Test
    void setName() {
        product.setName("thing");
        assertEquals("thing",product.getName());
    }

    @Test
    void getAmount() {
        assertEquals(5,product.getAmount());
    }

    @Test
    void setAmount() {
        product.setAmount(4);
        assertEquals(4,product.getAmount());
    }

    @Test
    void isEmpty() {
    assertFalse(product.isEmpty());
    }

    @Test
    void testToString() {
    String toString = product.toString();
    assertTrue(toString.contains("Product"));
    }

}