package main.java.patterns;

import java.util.ArrayList;
import java.util.List;

interface Item {
    String getName();
    float getPrice();
}

enum BurgerType {
    VEGGIE("Veggie Burger", 5f),
    BEEF("Beef Burger", 9f),
    CHICKEN("Chicken Burger", 7f);
    public final String name;
    public final float price;
    BurgerType(String name, float price) {
        this.name = name;
        this.price = price;
    }
}

class Burger implements Item {
    BurgerType type;
    Burger(BurgerType type) { this.type = type; }
    @Override public float getPrice() { return type.price; }
    @Override public String getName() { return type.name(); }
}

class Meal {
    List<Item> items;
    Meal() { items = new ArrayList<>(); }
    void addItem(Item item) { items.add(item); }
    float getCost() {
        float cost = 0.0f;
        for (Item item : items) cost += item.getPrice();
        return cost;
    }
}

class MealBuilder {
    Meal veggieCombo() {
        Meal meal = new Meal();
        meal.addItem(new Burger(BurgerType.VEGGIE));
        return meal;
    }
    Meal beefCombo() {
        Meal meal = new Meal();
        meal.addItem(new Burger(BurgerType.BEEF));
        return meal;
    }
}

class Builder {
    public static void main(String[] args) {
        MealBuilder builder = new MealBuilder();
        Meal veggie = builder.veggieCombo();
        Meal beef = builder.beefCombo();
        System.out.println("Order cost: " + veggie.getCost() + beef.getCost());
    }
}
