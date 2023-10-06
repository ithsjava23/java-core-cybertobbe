package org.example.warehouse;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Warehouse {

    private List<ProductRecord> productRecord = new ArrayList<>();
    private String name;
    private Warehouse(String name) {
        this.name = "MyStore";
    }


    public static Warehouse getInstance(String name) {
        Warehouse warehouse = new Warehouse("MyStore");
        return warehouse;
    }

    public boolean isEmpty() {
        return true;
    }

    public List<ProductRecord> getProducts() {
        return productRecord;
    }

    public ProductRecord addProduct(UUID uuidMilk, String milk, Category dairy, BigDecimal bigDecimal) {
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
        return getProducts();
    }

    public void updateProductPrice(UUID uuid, BigDecimal bigDecimal) {

    }
}