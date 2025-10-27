package lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Абстрактный базовый класс для блюда
 */
public class lab3lib{
public abstract class Dish {
    private String name;
    private double price;
    private int calories;
    private boolean veganFriendly;

    public Dish(String name, double price, int calories, boolean veganFriendly) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.veganFriendly = veganFriendly;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isVeganFriendly() {
        return veganFriendly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dish)) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 &&
                calories == dish.calories &&
                veganFriendly == dish.veganFriendly &&
                Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, calories, veganFriendly);
    }

    @Override
    public String toString() {
        return String.format("%s{name='%s', price=%.2f, calories=%d, veganFriendly=%b}",
                this.getClass().getSimpleName(), name, price, calories, veganFriendly);
    }
}

/**
 * Класс Напиток, наследник Dish
 */
public class Drink extends Dish {
    public Drink(String name, double price, int calories, boolean veganFriendly) {
        super(name, price, calories, veganFriendly);
    }
}

/**
 * Класс Тост, наследник Dish
 */
public class Toast extends Dish {
    public Toast(String name, double price, int calories, boolean veganFriendly) {
        super(name, price, calories, veganFriendly);
    }
}

/**
 * Класс Меню, содержит список блюд и методы для работы с меню
 */
public class Menu {
    private List<Dish> dishes;

    public Menu() {
        dishes = new ArrayList<>();
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public List<Dish> getAllDishes() {
        return new ArrayList<>(dishes);
    }

    public List<Dish> getVeganFriendlyDishes() {
        List<Dish> veganDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.isVeganFriendly()) {
                veganDishes.add(dish);
            }
        }
        return veganDishes;
    }

    public double averagePriceForHighCalorieDishes(int calorieThreshold) {
        double sum = 0;
        int count = 0;
        for (Dish dish : dishes) {
            if (dish.getCalories() > calorieThreshold) {
                sum += dish.getPrice();
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}
}