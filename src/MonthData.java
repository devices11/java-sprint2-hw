public class MonthData {
    int[] days = new int[30];

    //Количество пройденных шагов по дням
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            if (days[i] > 0) {
                System.out.println((i + 1) + " день: " + days[i]);
            }
        }
    }

    //Общее количество шагов за месяц
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int day : days) {
            sumSteps += day;
        }
        return sumSteps;
    }

    //Максимальное количество шагов в месяце
    int maxSteps() {
        int maxSteps = 0;
        for (int day : days) {
            if (day > maxSteps) {
                maxSteps = day;
            }
        }
        return maxSteps;
    }

    //Лучшая серия. Максимальное количество подряд идущих элементов days[], больших, чем goalByStepsPerDay, или равных ему
    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int day : days) {
            if (day >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                currentSeries = 0;
            }

            if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
            }
        }
        return finalSeries;
    }
}
