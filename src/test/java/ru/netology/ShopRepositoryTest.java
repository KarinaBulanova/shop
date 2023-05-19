package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void mustRemoveTheExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Вода", 50);
        Product product2 = new Product(61, "Телевизор", 14_000);
        Product product3 = new Product(454, "Машина", 5_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(454);
        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2};

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void attemptToRemoveNonExistentProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Вода", 50);
        Product product2 = new Product(61, "Телевизор", 14_000);
        Product product3 = new Product(454, "Машина", 5_000_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(54));
    }
}