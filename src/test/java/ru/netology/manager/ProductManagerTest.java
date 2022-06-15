package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;

public class ProductManagerTest{
    Product book = new Book(1, "Evgenii Onegin", 100, "Pushkin A.S.");
    Product smph = new Smartphone(2, "Mi 12", 20000, "Xiaomi");
    Product book1 = new Book(3, "idiot", 150, "Dostoevskii F.M.");
    Product smph2 = new Smartphone(4, "12 pro max", 900000, "Iphone");
    @Test
    public  void test(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(smph);
        manager.add(book1);
        manager.add(smph2);
        repo.removeById(3);
        manager.findAll();

        Product[] actual = manager.searchBy("in");
        Product[] expected = {book};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void test1(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(smph);
        manager.add(book1);
        manager.add(smph2);
        repo.removeById(3);
        manager.findAll();

        Product[] actual = manager.searchBy("ov");
        Product[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void test2(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.add(book);
        manager.add(smph);
        manager.add(book1);
        manager.add(smph2);
        repo.removeById(1);
        manager.findAll();

        Product[] actual = manager.searchBy("12");
        Product[] expected = {smph2, smph};
        Assertions.assertArrayEquals(expected, actual);
    }

}