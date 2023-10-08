package org.example.warehouse;

import java.util.Objects;

public class Category{


    private final String name;
    private Category(String name){
        if(name == null)
            throw new IllegalArgumentException("Category name can't be null");
        this.name = name.substring(0,1).toUpperCase() + name.substring(1);
    }
    public static Category of(String name) {
        if(name == null)
            throw new IllegalArgumentException("Category name can't be null");




        return new Category(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category category)) return false;
        return Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }


}
