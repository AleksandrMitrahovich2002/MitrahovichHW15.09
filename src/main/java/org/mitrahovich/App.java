package org.mitrahovich;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main(String[] args) {
        // Создаем список автомобилей
        List<Car> cars = createCarList();

        System.out.println("=== Все автомобили ===");
        printAllCars(cars);

        System.out.println("\n=== Автомобили после 2006 года ===");
        printCarsAfterYear(cars, 2006);

        System.out.println("\n=== Изменение зеленого цвета на красный ===");
        changeGreenToRed(cars);
        printAllCars(cars);

        System.out.println("\n=== Повышение цен на автомобили с механической коробкой ===");
        increasePriceForManualCars(cars, 2000);
        printAllCars(cars);
    }

    // Метод для создания списка автомобилей
    public static List<Car> createCarList() {
        List<Car> cars = new ArrayList<>();

        // Добавляем 10+ автомобилей разных марок
        cars.add(new Toyota("Camry", 2023, "Черный", true, 2.5, 203, 35000, 5, true, 6.2));
        cars.add(new Suzuki("Vitara", 2022, "Зеленый", true, 1.4, 140, 28000, true, "5 звезд"));
        cars.add(new BMW("X5", 2023, "Синий", true, 3.0, 340, 75000, true, "AWD", true));
        cars.add(new Mercedes("E-Class", 2021, "Зеленый", true, 2.0, 255, 60000, true, true, "Кожа"));
        cars.add(new Honda("Civic", 2020, "Белый", false, 1.5, 182, 25000, true, 420, true));
        cars.add(new Toyota("Corolla", 2005, "Серый", false, 1.8, 132, 8000, 3, false, 7.8));
        cars.add(new Suzuki("Swift", 2018, "Красный", false, 1.2, 90, 15000, false, "4 звезды"));
        cars.add(new BMW("3 Series", 2019, "Зеленый", true, 2.0, 184, 45000, false, "RWD", false));
        cars.add(new Mercedes("S-Class", 2022, "Черный", true, 3.0, 435, 120000, true, true, "Премиальная кожа"));
        cars.add(new Honda("CR-V", 2017, "Серебристый", true, 2.4, 190, 30000, true, 560, false));
        cars.add(new Toyota("RAV4", 2004, "Желтый", true, 2.0, 150, 5000, 2, false, 9.1));

        return cars;
    }

    // Метод для вывода всех автомобилей
    public static void printAllCars(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            System.out.println((i + 1) + ". " + cars.get(i).getFullInfo());
        }
    }

    // Метод 1: Вывод информации об автомобилях после указанного года
    public static void printCarsAfterYear(List<Car> cars, int year) {
        boolean found = false;

        for (Car car : cars) {
            if (car.getYear() > year) {
                System.out.println(car.getFullInfo());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Автомобили после " + year + " года не найдены");
        }
    }

    // Метод 2: Изменение зеленого цвета на красный
    public static void changeGreenToRed(List<Car> cars) {
        int changedCount = 0;

        for (Car car : cars) {
            if ("Зеленый".equalsIgnoreCase(car.getColor())) {
                System.out.println("Меняем цвет " + car.getBrand() + " " + car.getModel() +
                        " с зеленого на красный");
                car.changeColor("Красный");
                changedCount++;
            }
        }

        System.out.println("Изменено автомобилей: " + changedCount);
    }

    // Метод 3: Повышение цены для автомобилей с механической коробкой
    public static void increasePriceForManualCars(List<Car> cars, double increaseAmount) {
        int increasedCount = 0;

        for (Car car : cars) {
            if (!car.isAutomatic()) { // Если механическая коробка
                double oldPrice = car.getPrice();
                double newPrice = oldPrice + increaseAmount;
                car.updatePrice(newPrice);
                System.out.println(car.getBrand() + " " + car.getModel() +
                        ": цена увеличена с $" + oldPrice + " до $" + newPrice);
                increasedCount++;
            }
        }

        System.out.println("Цены увеличены для " + increasedCount + " автомобилей с механической коробкой");
    }

    // Дополнительный метод: Поиск автомобилей по марке
    public static void findCarsByBrand(List<Car> cars, String brand) {
        System.out.println("\n=== Автомобили марки " + brand + " ===");
        boolean found = false;

        for (Car car : cars) {
            if (brand.equalsIgnoreCase(car.getBrand())) {
                System.out.println(car.getFullInfo());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Автомобили марки " + brand + " не найдены");
        }
    }

    // Дополнительный метод: Средняя цена автомобилей
    public static void calculateAveragePrice(List<Car> cars) {
        double total = 0;

        for (Car car : cars) {
            total += car.getPrice();
        }

        double average = total / cars.size();
        System.out.println("\nСредняя цена всех автомобилей: $" + String.format("%.2f", average));
    }
}

