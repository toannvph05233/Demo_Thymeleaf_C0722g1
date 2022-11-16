package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product(1,"Toan","http://hanoimoi.com.vn/Uploads/tuandiep/2018/4/8/1(1).jpg",200, true));
        products.add(new Product(2,"Toan2","https://kynguyenlamdep.com/wp-content/uploads/2020/01/hinh-anh-chu-chim-dep.jpg",200, false));
        products.add(new Product(3,"Toan3","https://kynguyenlamdep.com/wp-content/uploads/2020/01/hinh-anh-chu-chim-dep.jpg",200, true));
    }

    public void add(Product product){
        products.add(product);
    }
    public void edit(int id, Product product){
        int index = findIndexById(id);
        if (index!= -1){
            products.set(index,product);
        }
    }

    public int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    public void delete(int id){
        int index = findIndexById(id);
        if (index != -1){
            products.remove(index);
        }
    }


}
