package racing;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RandomRacingGame extends RacingGame {

    public RandomRacingGame(String[] names, int times) {
        super(names, times);
    }

    public RandomRacingGame(Car[] cars, int turn) {
        super(cars, turn);
        checkCars(cars);
    }

    private void checkCars(Car[] cars) {
        if (!Arrays.stream(cars).
            allMatch(car -> car.getStrategy() == RandomMoveStrategy.getInstance())) {
            throw new IllegalArgumentException("Car should be random car");
        }
    }

    @Override
    protected Car[] createCars(String[] names) {
        Car[] cars = new Car[names.length];
        IntStream.range(0, names.length)
                 .forEach(i -> cars[i] = new Car(RandomMoveStrategy.getInstance(), names[i]));

        return cars;
    }
}
