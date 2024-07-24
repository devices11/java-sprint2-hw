public class Converter {
    //Переводим количество шагов в километры
    static int convertToKm(int steps) {
        final int CENTIMETERS_PER_STEP = 75;
        final int CENTIMETERS_PER_KILOMETER = 100000;
        return (steps * CENTIMETERS_PER_STEP / CENTIMETERS_PER_KILOMETER);
    }

    //Переводим количество шагов в килокалории
    static int convertStepsToKilocalories(int steps) {
        final int CALORIES_PER_STEP = 50;
        final int CALORIES_PER_KILOCALORIE = 1000;
        return (steps * CALORIES_PER_STEP / CALORIES_PER_KILOCALORIE);
    }
}
