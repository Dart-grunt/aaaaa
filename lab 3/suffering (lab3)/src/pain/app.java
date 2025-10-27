package pain;
import java.util.List;
import lib.*;
public class app
{
	public static void main(String[] args) {
		var x = new lab3lib();
        lab3lib.Menu menu = x.new Menu();

        // Добавляем не менее 10 блюд (напитков и тостов)
        menu.addDish(x.new Drink("Апельсиновый сок", 150.0, 120, true));
        menu.addDish(x.new Drink("Кофе латте", 200.0, 180, false));
        menu.addDish(x.new Drink("Зеленый чай", 100.0, 5, true));
        menu.addDish(x.new Drink("Молочный коктейль", 250.0, 350, false));
        menu.addDish(x.new Drink("Свежевыжатый морковный сок", 180.0, 80, true));

        menu.addDish(x.new Toast("Тост с авокадо", 220.0, 320, true));
        menu.addDish(x.new Toast("Тост с сыром и ветчиной", 250.0, 400, false));
        menu.addDish(x.new Toast("Тост с томатами и базиликом", 210.0, 310, true));
        menu.addDish(x.new Toast("Тост с лососем", 300.0, 450, false));
        menu.addDish(x.new Toast("Тост с хумусом", 230.0, 290, true));

        // Вывод всего меню
        System.out.println("=== Все блюда в меню ===");
        List<lab3lib.Dish> allDishes = menu.getAllDishes();
        for (lab3lib.Dish dish : allDishes) {
            System.out.println(dish);
        }

        // Вывод vegan friendly блюд
        System.out.println("\n=== Vegan friendly блюда ===");
        List<lab3lib.Dish> veganDishes = menu.getVeganFriendlyDishes();
        for (lab3lib.Dish dish : veganDishes) {
            System.out.println(dish);
        }

        // Подсчет средней стоимости блюд с калорийностью более 300
        double avgPrice = menu.averagePriceForHighCalorieDishes(300);
        System.out.printf("\nСредняя стоимость блюд с калорийностью более 300: %.2f\n", avgPrice);
    }
}