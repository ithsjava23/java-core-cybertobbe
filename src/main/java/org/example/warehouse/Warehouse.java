package org.example.warehouse;


import java.math.BigDecimal;
import java.util.*;

public class Warehouse {

    private final List<ProductRecord> productRecord = new ArrayList<>();
    private  String name;

    private Warehouse(String name) {
        this.name = "MyStore";
    }


    public static Warehouse getInstance(String name) {

        return new Warehouse(name);
    }

    public boolean isEmpty() {
        return productRecord.isEmpty();
    }

    public ProductRecord addProduct(UUID uuid, String name, Category category, BigDecimal price) {

        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Product name cannot be empty.");
        if(price == null)
            price = BigDecimal.ZERO;
        if(category == null) {
            throw new IllegalArgumentException("Category cannot be null.");
        }
        if(uuid == null) {
            uuid = UUID.randomUUID();
        }
        productRecord.add(new ProductRecord(name, uuid, category, price));
        return new ProductRecord(name, uuid, category, price);


    }

    public Optional<ProductRecord> getProductById(UUID uuid) {

        return productRecord.stream()
                .filter(productRecord -> productRecord.getUuid().equals(uuid)).findFirst();
    }

    public List<ProductRecord> getChangedProducts() {
        return null;
    }


    public boolean getProductsGroupedByCategories() {
        return false;
    }

    public List<ProductRecord> getProductsBy(Category category) {
        return null;
    }

    public List<ProductRecord> getProducts() {
        return Collections.unmodifiableList(productRecord);


    }

    public void updateProductPrice(UUID uuid, BigDecimal bigDecimal) {

    }
}