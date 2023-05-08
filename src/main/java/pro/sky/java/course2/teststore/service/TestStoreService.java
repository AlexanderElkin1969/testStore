package pro.sky.java.course2.teststore.service;

import pro.sky.java.course2.teststore.model.*;

import java.util.List;
import java.util.Map;

public interface TestStoreService {

    public Map<String, Product> getList();

    public Product add(String id, int quantity);

    public List<Product> get();
}
