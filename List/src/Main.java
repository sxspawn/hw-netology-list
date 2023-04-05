import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> purchases = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию: \n" +
                    "1 - добавить, 2 - показать, 3 - удалить, 4 - найти, 5 - завершить.");
            String input = scanner.nextLine();
            if ("5".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }
            switch (input) {
                case "1":
                    addProduct(purchases, scanner);
                    break;
                case "2":
                    shoppingListView(purchases);
                    break;
                case "3":
                    delProduct(purchases, scanner);
                    break;
                case "4":
                    searchProduct(purchases, scanner);
                    break;
                default:
                    System.out.println("Неверная операция.");
                    break;
            }
        }
    }

    private static void delProduct(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Выберите способ удаления: 1 - по номеру, 2 - по названию");
        String deleteMethod = scanner.nextLine();
        scanner.nextLine();
        switch (deleteMethod) {
            case "1":
                delByProductNumber(purchases, scanner);
                break;
            case "2":
                delByProductName(purchases, scanner);
                break;
            default:
                System.out.println("Неверный способ удаления.");
                break;
        }
    }

    private static void delByProductName(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите название покупки:");
        String purchaseName = scanner.nextLine();
        purchases.remove(purchaseName);
    }

    private static void delByProductNumber(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите номер покупки:");
        int purchaseNumber = scanner.nextInt();
        scanner.nextLine();
        purchases.remove(purchaseNumber - 1);
    }

    private static void searchProduct(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите ключевое слово для поиска:");
        String keyword = scanner.nextLine().toLowerCase();
        boolean found = false;
        for (int i = 0; i < purchases.size(); i++) {
            if (purchases.get(i).toLowerCase().contains(keyword)) {
                if (!found) {
                    System.out.println("Результаты поиска:");
                    found = true;
                }
                System.out.println((i + 1) + ". " + purchases.get(i));
            }
        }
        if (!found) {
            System.out.println("По запросу \"" + keyword + "\" ничего не найдено");
        }
    }

    private static void shoppingListView(ArrayList<String> purchases) {
        System.out.println("Список покупок: ");
        for (int i = 0; i < purchases.size(); i++) {
            System.out.println((i + 1) + ". " + purchases.get(i));
        }
    }

    private static void addProduct(ArrayList<String> purchases, Scanner scanner) {
        System.out.println("Введите название покупки:");
        String purchase = scanner.nextLine();
        purchases.add(purchase);
        System.out.println("Количество покупок: " + purchases.size());
    }
}