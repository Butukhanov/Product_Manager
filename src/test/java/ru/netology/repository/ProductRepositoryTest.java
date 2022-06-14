package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;
import ru.netology.manager.ProductManager;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductRepositoryTest{
    Product book = new Book(1, "Evgenii Onegin", 100, "Pushkin A.S.");
    Product smph = new Smartphone(2, "Mi 12", 20000, "Xiaomi");
    Product book1 = new Book(3, "idiot", 150, "Dostoevskii F.M.");
    Product smph2 = new Smartphone(4, "13 pro max", 900000, "Iphone");
    @Test
    public  void test(){
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        manager.save(book);
        manager.save(smph);
        manager.save(book1);
        manager.save(smph2);
        repo.removeById(5);
        manager.findAll();

        Product[] actual = manager.searchBy("in");
        Product[] expected = {book};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void test1(){
        ProductRepository repo = new ProductRepository();

        repo.save(book);
        repo.save(smph);
        repo.save(book1);
        repo.save(smph2);

        assertThrows(NotFoundException.class, () ->{
            repo.removeById(9);
        });

    }

}