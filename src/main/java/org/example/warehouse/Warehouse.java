package org.example.warehouse;


import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Warehouse {

    //List for products
    private final List<ProductRecord> productRecord = new ArrayList<>();
    //List for changed product
    private final List<ProductRecord> changedProductRecord = new ArrayList<>();
    //Name of instance of Warehouse
    private final String name;

    private Warehouse(String name) {
        this.name = name;
    }
    public static Warehouse getInstance(String name) {
        return new Warehouse(name);
    }

    public boolean isEmpty() {
        return productRecord.isEmpty();
    }
    public ProductRecord addProduct(UUID uuid, String name, Category category, BigDecimal price) {

        if(name == null || name.isEmpty())
            throw new IllegalArgumentException("Product name can't be null or empty.");

        if(price == null)
            price = BigDecimal.ZERO;


        if(category == null)
            throw new IllegalArgumentException("Category can't be null.");

        if(uuid == null)
            uuid = UUID.randomUUID();

        UUID finalizedUuid = uuid; //finalized copy of uuid for lambda
        if(productRecord.stream()
                .anyMatch(productRecord -> productRecord.getUuid().equals(finalizedUuid)))
            throw new IllegalArgumentException("Product with that id already exists, use updateProduct for updates.");


        ProductRecord productAdd = new ProductRecord(name, uuid, category, price);
        productRecord.add(productAdd);
        return productAdd;


    }
    public Optional<ProductRecord> getProductById(UUID uuid) {

        return productRecord.stream()
                .filter(productRecord -> productRecord.getUuid().equals(uuid)).findFirst();
    }
    public List<ProductRecord> getChangedProducts() {
        return Collections.unmodifiableList(changedProductRecord);
    }

    public Map<Category, List<ProductRecord>> getProductsGroupedByCategories() {
        return productRecord.stream()
                .collect(Collectors.groupingBy(ProductRecord::getCategory));

    }

    public List<ProductRecord> getProductsBy(Category category) {
        return productRecord.stream()
                .filter(productRecord -> productRecord.getCategory().equals(category))
                .toList();
    }
    public List<ProductRecord> getProducts() {
        return Collections.unmodifiableList(productRecord);
    }

    public void updateProductPrice(UUID uuid, BigDecimal newPrice) {

        Optional<ProductRecord> changedOptional = getProductById(uuid);
        if (changedOptional.isPresent()) {
            ProductRecord updateProduct = changedOptional.get();
            updateProduct.setPrice(newPrice);
            changedProductRecord.add(updateProduct);

        }
            else {
            throw new IllegalArgumentException("Product with that id doesn't exist.");
        }



    }
}