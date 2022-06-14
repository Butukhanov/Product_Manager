package ru.netology.repository;

import ru.netology.domain.Product;



public class ProductRepository {
    protected Product[] items = new Product[0];

    public void save(Product item){
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < items.length; i++){
            tmp[i] = items[i];
        }
        int lastIndex = tmp.length-1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll(){
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++){
            int index = items.length - i-1;
            result[i] = items[index];
        }
        return result;
    }

    public  Product findById(int id){
        for (Product item : items){
            if (item.getId() == id){
                return item;
            }
        }
        return  null;
    }

    public void throwUnchecked(int id){
        throw new NotFoundException("Element with id:" + id + "not found");
    }

    public void removeById(int id){
        if (this.findById(id) == null){
            this.throwUnchecked(id);
        } else{
            int length = items.length-1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items){
                if (item.getId() != id){
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }


    }
}
