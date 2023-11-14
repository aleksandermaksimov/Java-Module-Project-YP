import java.io.Serializable;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static List<ProductsRoster> product = new ArrayList<>();
    public static List<ProductsRoster> getProduct() {
        while(true) {
            System.out.println("Добавить товар? Если да  - введите любой символ, если нет - введите Завершить");
            String guestInput = scanner.next();
            if(guestInput.equalsIgnoreCase("Завершить")) {
                if(product.size() < 1) {
                    System.out.println("Ошибка. Введите товар.");
                } else {
                    System.out.println("Добавленные товары:\n");
                for(ProductsRoster products: product) {
                    System.out.println("Товар успешно добавлен: " + products.productName + " стоимость: " + products.productCost);
                }
                    return product;
                }
            } else {
                String ProductName = getProductName();
                Double ProductCost = getProductCost();
                ProductsRoster element = new ProductsRoster(ProductName, ProductCost);
                product.add(element);
                System.out.println("Наименование товара " + product.get(product.size() - 1).productName + " стоимость: " + product.get(product.size() - 1).productCost);
            }
        }
    }



    public static String getProductName() {
        System.out.println("Введите название товара.");
        return scanner.next();
    }
    public static Double getProductCost() {
        System.out.println("Введите стоимость товара.");
        double tag = 0.0;
        while (true) {
            if(scanner.hasNextDouble()) {
                tag = scanner.nextDouble();
                if (tag > 0) {
                    return Double.parseDouble(String.format("%2f", tag).replace(',' , '.'));
                } else {
                    System.out.println("Повторите ввод, так как цена отрицательная или равна нулю.");
                    continue;
                }
            }
            System.out.println("Стоимость товара должна быть в формате ~00.00~.");
            scanner.next();
        }
    }
    public static class ProductsRoster {
        private final String productName;
        final Double productCost;
        public ProductsRoster(String productName, Double productCost) {
            this.productName = productName;
            this.productCost = productCost;
        }
    }
}
