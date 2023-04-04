import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> purchases = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите операцию: \n1 - добавить, 2 - показать, 3 - удалить, 4 - найти, 5 - завершить.");
            String input = scanner.nextLine();
            if ("5".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            }
            switch (input) {
                case "1":
                    System.out.println("Введите название покупки:");
                    String purchase = scanner.nextLine();
                    purchases.add(purchase);
                    System.out.println("Количество покупок: " + purchases.size());
                    break;
                case "2":
                    System.out.println("Список покупок: ");
                    for (int i = 0; i < purchases.size(); i++) {
                        System.out.println((i + 1) + ". " + purchases.get(i));
                    }
                    break;
                case "3":
                    System.out.println("Выберите способ удаления: 1 - по номеру, 2 - по названию");
                    String deleteMethod = scanner.nextLine();
                    scanner.nextLine();
                    switch (deleteMethod) {
                        case "1":
                            System.out.println("Введите номер покупки:");
                            int purchaseNumber = scanner.nextInt();
                            scanner.nextLine();
                            purchases.remove(purchaseNumber - 1);
                            break;
                        case "2":
                            System.out.println("Введите название покупки:");
                            String purchaseName = scanner.nextLine();
                            purchases.remove(purchaseName);
                            break;
                        default:
                            System.out.println("Неверный способ удаления.");
                            break;
                    }
                    break;
                case "4":
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
                    break;
                default:
                    System.out.println("Неверная операция.");
                    break;
            }
        }
    }
}