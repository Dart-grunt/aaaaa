import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lab1ref.product;

// main stand-in
public class lab1 {
    public static void main(String[] args) {
        product[] products = new product[]{
                new product(1, "moloko", "123456789012", "Ферма A. F.", 50.0, 7, 100),
                new product(2, "xleb", "987654321098", "Пекарня", 30.0, 3, 200),
                new product(3, "moloko", "123450987654", "Ферма I. Z.", 45.0, 5, 50),
                new product(4, "yabloki", "567890123456", "Сад", 70.0, 10, 150),
                new product(5, "moloko", "123098456789", "Завод", 55.0, 10, 90),
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите наименование товара для поиска: ");
        String name = scanner.nextLine();
        List<product> listByName = findByName(products, name);
        System.out.println("Товары с наименованием '" + name + "':");
        printProducts(listByName);

        System.out.print("Введите наименование товара для поиска с ограничением по цене: ");
        String nameForPrice = scanner.nextLine();
        System.out.print("Введите максимальную цену: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        List<product> listByNameAndPrice = findByNameAndMaxPrice(products, nameForPrice, maxPrice);
        System.out.println("Товары с наименованием '" + nameForPrice + "' и ценой не выше " + maxPrice + ":");
        printProducts(listByNameAndPrice);

        System.out.print("Введите минимальный срок хранения (в днях): ");
        int minShelfLife = scanner.nextInt();

        List<product> listByShelfLife = findByShelfLifeGreaterThan(products, minShelfLife);
        System.out.println("Товары со сроком хранения больше " + minShelfLife + " дней:");
        printProducts(listByShelfLife);

        scanner.close();
    }

    // part a
    private static List<product> findByName(product[] products, String name) {
        List<product> result = new ArrayList<>();
        for (product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    // part b
    private static List<product> findByNameAndMaxPrice(product[] products, String name, double maxPrice) {
        List<product> result = new ArrayList<>();
        for (product product : products) {
            if (product.getName().equalsIgnoreCase(name) && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    // part c
    private static List<product> findByShelfLifeGreaterThan(product[] products, int minShelfLife) {
        List<product> result = new ArrayList<>();
        for (product product : products) {
            if (product.getShelfLife() > minShelfLife) {
                result.add(product);
            }
        }
        return result;
    }

    private static void printProducts(List<product> products) {
        if (products.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (product product : products) {
                System.out.println(product);
            }
        }
    }
}