import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int id;
    private String name; 
    private String upc; 
    private String producer; 
    private double price; 
    private int shelfLife; 
    private int amount; 

    public Product(int id, String name, String upc, String producer, double price, int shelfLife, int amount) {
        this.id = id;
        this.name = name;
        this.upc = upc;
        this.producer = producer;
        this.price = price;
        this.shelfLife = shelfLife;
        this.amount = amount;
    }

    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUpc() {
        return upc;
    }

    public String getproducer() {
        return producer;
    }

    public double getPrice() {
        return price;
    }

    public int getShelfLife() {
        return shelfLife;
    }

    public int getamount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', UPC='%s', producer='%s', price=%.2f, shelfLife=%d, amount=%d}",
                id, name, upc, producer, price, shelfLife, amount);
    }
}

// main stand-in
public class lab1 {
    public static void main(String[] args) {
        Product[] products = new Product[]{
                new Product(1, "moloko", "123456789012", "Ферма A. F.", 50.0, 7, 100),
                new Product(2, "xleb", "987654321098", "Пекарня", 30.0, 3, 200),
                new Product(3, "moloko", "123450987654", "Ферма I. Z.", 45.0, 5, 50),
                new Product(4, "yabloki", "567890123456", "Сад", 70.0, 10, 150),
                new Product(5, "moloko", "123098456789", "Завод", 55.0, 10, 90),
        };

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите наименование товара для поиска: ");
        String name = scanner.nextLine();
        List<Product> listByName = findByName(products, name);
        System.out.println("Товары с наименованием '" + name + "':");
        printProducts(listByName);

        System.out.print("Введите наименование товара для поиска с ограничением по цене: ");
        String nameForPrice = scanner.nextLine();
        System.out.print("Введите максимальную цену: ");
        double maxPrice = scanner.nextDouble();
        scanner.nextLine();
        List<Product> listByNameAndPrice = findByNameAndMaxPrice(products, nameForPrice, maxPrice);
        System.out.println("Товары с наименованием '" + nameForPrice + "' и ценой не выше " + maxPrice + ":");
        printProducts(listByNameAndPrice);

        System.out.print("Введите минимальный срок хранения (в днях): ");
        int minShelfLife = scanner.nextInt();

        List<Product> listByShelfLife = findByShelfLifeGreaterThan(products, minShelfLife);
        System.out.println("Товары со сроком хранения больше " + minShelfLife + " дней:");
        printProducts(listByShelfLife);

        scanner.close();
    }

    // part a
    private static List<Product> findByName(Product[] products, String name) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                result.add(product);
            }
        }
        return result;
    }

    // part b
    private static List<Product> findByNameAndMaxPrice(Product[] products, String name, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name) && product.getPrice() <= maxPrice) {
                result.add(product);
            }
        }
        return result;
    }

    // part c
    private static List<Product> findByShelfLifeGreaterThan(Product[] products, int minShelfLife) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getShelfLife() > minShelfLife) {
                result.add(product);
            }
        }
        return result;
    }

    private static void printProducts(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("Список пуст.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }
}