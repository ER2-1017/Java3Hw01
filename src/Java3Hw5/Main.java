package Java3Hw5;

public class Main {
    public static final int CARS_COUNT = 4;
    public static final String preparationMessage = "ВАЖНОЕ ОБЪЯВЕНИЕ >>> Подготовка!!!";
    public static final String startMessage = "ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка началась!!!";
    public static final String finishMessage = "ВАЖНОЕ ОБЪЯВЕНИЕ >>> Гонка закончилась!!!";
    public static final String winMessage = " - WIN";

    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
    }
}