package jdk.test.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MyStreamTest {

    @Test
    public void testFilter() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car(1, "Peter"));
        cars.add(new Car(2, "Marry"));
        cars.add(new Car(3, "Ben"));
        cars.add(new Car(4, "Peter"));
        List<Car> list2 = cars.stream()
                .filter(distinctByKey(car -> car.owner))
                .collect(Collectors.toList());
        System.out.println(list2);


        List<Car> list3 = cars.stream()
                .filter(new Predicate<Car>() {  // equals -> distinctByKey(car -> car.owner)
                    Map<Object,Boolean> seen = new ConcurrentHashMap<>();
                    @Override
                    public boolean test(Car car) {
                        return seen.putIfAbsent(car.owner, Boolean.TRUE) == null;
                    }
                })
                .collect(Collectors.toList());
        System.out.println(list2);
    }

    private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    class Car {
        private int id;
        private String owner;
        public Car(int id, String owner) {
            this.id = id;
            this.owner = owner;
        }
    }
}
