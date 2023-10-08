package org.example.warehouse;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Category{


    private final String name;

    private static final Map<String, Category> catList = new HashMap<>();
    private Category(String name){
        if(name == null)
            throw new IllegalArgumentException("Category name can't be null");
        this.name = name.substring(0,1).toUpperCase() + name.substring(1);
    }
    public static Category of(String name) {
        if(name == null)
            throw new IllegalArgumentException("Category name can't be null");

        return catList.computeIfAbsent(name, key -> new Category(key));
    }


    public String getName() {

        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return Objects.equals(name, category.name);
    }


    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
