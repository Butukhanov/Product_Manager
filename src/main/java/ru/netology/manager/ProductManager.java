package ru.netology.manager;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManager {
//    Book book = new Book(1, "Glass", 100, "Ivanov");
//    Smartphone smartphone = new Smartphone(2, "Xiaomi Mi 12", 20000, "Xiaomi");
    protected ProductRepository repository;
    public ProductManager(ProductRepository repo){
        this.repository = repo;
    }
    public void save(Product product){
        repository.save(product);
    }
//    public void removeById (int product){
//        repository.removeById(Product product);
//    }
    public Product[] findAll(){
        Product[] items = repository.findAll();
        return items;
    }


    // добавьте необходимые поля, конструкторы и методы

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++){
                    tmp[i] = result[i];
                }
                tmp[tmp.length-1] = product;
                result = tmp;
                // "добавляем в конец" массива result продукт product
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}