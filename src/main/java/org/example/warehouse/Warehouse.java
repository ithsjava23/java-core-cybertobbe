package org.example.warehouse;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Warehouse {

    private final List<ProductRecord> productRecord = new ArrayList<>();
    private String name;

    private Warehouse(String name) {
        this.name = "MyStore";
    }


    public static Warehouse getInstance(String name) {

        return new Warehouse(name);
    }

    public boolean isEmpty() {
        return productRecord.isEmpty();
    }

    public ProductRecord addProduct(UUID uuidMilk, String milk, Category dairy, BigDecimal bigDecimal) {

        if (milk == null || milk.isEmpty()) {
            throw new IllegalArgumentException("Product name can't be empty.");
        }

        //
        return null;
    }

    public Optional<ProductRecord> getProductById(UUID uuid) {


        return null;
    }

    public List<ProductRecord> getChangedProducts() {
        return productRecord;
    }


    public boolean getProductsGroupedByCategories() {
        return false;
    }

    public List<ProductRecord> getProductsBy(Category meat) {
        return null;
    }

    public List<ProductRecord> getProducts() {
        return productRecord.stream().toList();
    }

    public void updateProductPrice(UUID uuid, BigDecimal bigDecimal) {

    }
}