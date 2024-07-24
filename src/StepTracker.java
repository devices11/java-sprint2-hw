import java.util.InputMismatchException;
import java.util.Scanner;

public class StepTracker {
    ConsoleColor consoleColor = new ConsoleColor();

    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        consoleColor.printGreen("Введите номер месяца: ");

        try {
            int month = scanner.nextInt();
            if (month < 1 || month > 12) {
                consoleColor.printlnRed("Месяц должен быть в диамазоне от 1 до 12. Вы ввели: " + month);
                return;
            }

            consoleColor.printGreen("Введите номер дня: ");
            int day = scanner.nextInt();
            if (day < 1 || day > 30) {
                consoleColor.printlnRed("День должен быть от 1 до 30. Вы ввели: " + day);

                return;
            }

            consoleColor.printGreen("Введите количество шагов: ");
            int steps = scanner.nextInt();
            if (steps < 0) {
                consoleColor.printlnRed("Количество шагов не может быть отрицательнным. Вы ввели: " + steps);
                return;
            }

            MonthData monthData = monthToData[month - 1];
            monthData.days[day - 1] = steps;
            System.out.println("-".repeat(20));
        } catch (InputMismatchException E) {
            consoleColor.printlnRed("Некорректный ввод! Доступно только положительное число.");
            scanner.next();
        }
    }

    void changeStepGoal() {
        consoleColor.printGreen("Введите целевое значение количества шагов на день (текущее: " + goalByStepsPerDay + "): ");
        try {
            int newGoalByStepsPerDay = scanner.nextInt();
            if (newGoalByStepsPerDay <= 0) {
                consoleColor.printlnRed("Количество шагов не может быть отрицательнным. Вы ввели: " + newGoalByStepsPerDay);
                return;
            }

            goalByStepsPerDay = newGoalByStepsPerDay;
            consoleColor.printlnBlue("Значение сохранено.");
            System.out.println("-".repeat(20));

        } catch (InputMismatchException E) {
            consoleColor.printlnRed("Некорректный ввод! Доступно только положительное число.");
            scanner.next();
        }
    }

    void printStatistic() {
        Converter converter = new Converter();

        try {
            consoleColor.printGreen("Введите номер месяца, за который хотете получить статистику: ");
            int month = scanner.nextInt();
            if (month < 1 || month > 12) {
                consoleColor.printlnRed("Месяц должен быть в диамазоне от 1 до 12. Вы ввели: " + month);
                return;
            }
            int sumStepsFromMonth = monthToData[month - 1].sumStepsFromMonth();

            if (sumStepsFromMonth == 0){
                consoleColor.printlnBlue("В указанном месяце данные отсутствуют.");
                return;
            }

            System.out.println("Количество пройденных шагов по дням:");
            monthToData[month - 1].printDaysAndStepsFromMonth();

            System.out.println("Общее количество шагов: " + sumStepsFromMonth);

            System.out.println("Максимальное количество шагов за день: " + monthToData[month - 1].maxSteps());

            System.out.println("Среднее количество шагов: " + sumStepsFromMonth / monthToData[month - 1].days.length);

            System.out.println("Пройденная дистанция (в километрах): "
                    + converter.convertToKm(sumStepsFromMonth));

            System.out.println("Количество сожжённых килокалорий: "
                    + converter.convertStepsToKilocalories(sumStepsFromMonth));

            System.out.println("Лучшая серия подряд идущих дней с выполненным планом шагов (" + goalByStepsPerDay + "): "
                    + monthToData[month - 1].bestSeries(goalByStepsPerDay));
            System.out.println("-".repeat(20));
        } catch (InputMismatchException E) {
            consoleColor.printlnRed("Некорректный ввод! Доступно только положительное число.");
            scanner.next();
        }
    }
}
