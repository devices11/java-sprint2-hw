import java.util.Scanner;

public class Main {
    static ConsoleColor consoleColor = new ConsoleColor();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        consoleColor.printlnBlue("-".repeat(40));
        consoleColor.printlnBlue("   Вас приветствует счетчик калорий!");
        consoleColor.printlnBlue("-".repeat(40));

        while (true) {
            switch (printMenu(scanner)) {
                case "1" -> stepTracker.addNewNumberStepsPerDay();
                case "2" -> stepTracker.changeStepGoal();
                case "3" -> stepTracker.printStatistic();
                case "4" -> {
                    return;
                }
                default -> consoleColor.printlnRed("Некорректная команда!");
            }
        }
    }

    static String printMenu(Scanner scanner) {
        consoleColor.printlnYellow("Меню:");
        consoleColor.printYellow("  1. ");
        System.out.println("Ввести количество шагов за определённый день");

        consoleColor.printYellow("  2. ");
        System.out.println("Изменить цель по количеству шагов в день");

        consoleColor.printYellow("  3. ");
        System.out.println("Вывести статистику за определённый месяц");

        consoleColor.printYellow("  4. ");
        System.out.println("Выход из приложения");

        consoleColor.printGreen("Введите одну из команд: ");

        return scanner.next();
    }
}