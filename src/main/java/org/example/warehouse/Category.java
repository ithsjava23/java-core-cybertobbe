package org.example.warehouse;

public class Category{
    private final String name;
    private static Category category;
    public Category(String name){

        this.name = name;
    }

    public static Category of(String name) {
        return category;
    }

    public String getName() {
        return name;
    }


}
