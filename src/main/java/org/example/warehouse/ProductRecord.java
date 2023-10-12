package org.example.warehouse;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class ProductRecord {

    private final String name;
    private final UUID uuid;
    private final Category category;
    private BigDecimal price;

    public ProductRecord(String name, UUID uuid, Category category, BigDecimal price) {
        this.name = name;
        this.uuid = uuid;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Category getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRecord that = (ProductRecord) o;
        return Objects.equals(name, that.name) && Objects.equals(uuid, that.uuid) && Objects.equals(category, that.category) && Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, uuid, category, price);
    }

    @Override
    public String toString() {
        return "ProductRecord{" +
                "name='" + name + '\'' +
                ", uuid=" + uuid +
                ", category=" + category +
                ", price=" + price +
                '}';
    }

    public UUID uuid() {
        return uuid;
    }

    public BigDecimal price() {
        return price;
    }

    public Category category() {
        return category;
    }
}
