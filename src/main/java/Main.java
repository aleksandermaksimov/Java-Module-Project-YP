import java.util.List;

public class Main {
    public static void main(String[] args) {
        int visitor = People.getNumberOfGuests();
        System.out.println("Количество гостей: " + visitor);
        List <Calculator.ProductsRoster> product = Calculator.getProduct();
        double totalAmount = 0.0;
        for (Calculator.ProductsRoster products: product) {
            totalAmount += products.productCost;
        }
        double finalAmount = totalAmount / visitor;
        printPrice(finalAmount);
    }

    private static void printPrice(double price) {
        String format = String.valueOf((int) price);
        int preLastDigit = Integer.parseInt(format) % 100 / 10;
        if (preLastDigit == 1) {
            System.out.println("Сумма к оплате: " + String.format("%.2f", price) + " рублей");
            return;
        }
        switch (Integer.parseInt(format) % 10) {
            case 1:
                System.out.println("Сумма к оплате: " + String.format("%.2f", price) + " рубль");
            case 2, 3, 4:
                System.out.println("Сумма к оплате: " + String.format("%.2f", price) + " рубля");
            default:
                System.out.println("Сумма к оплате: " + String.format("%.2f", price) + " рублей");
        }
    }
}









