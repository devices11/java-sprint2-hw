public class Converter {

    //Переводим количество шагов в километры
    int convertToKm(int steps) {
        final int centimetersPerStep = 75;
        final int centimetersPerKilometer = 100000;
        return (steps * centimetersPerStep / centimetersPerKilometer);
    }

    //Переводим количество шагов в килокалории
    int convertStepsToKilocalories(int steps) {
        final int caloriesPerStep = 50;
        final int caloriesPerKilocalorie = 1000;
        return (steps * caloriesPerStep / caloriesPerKilocalorie);
    }


}
