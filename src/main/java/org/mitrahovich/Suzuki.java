package org.mitrahovich;

public class Suzuki extends Car {
    private boolean allWheelDrive;
    private String safetyRating;

    public Suzuki(String model, int year, String color, boolean isAutomatic, 
                 double engineVolume, int horsepower, double price, 
                 boolean allWheelDrive, String safetyRating) {
        super("Suzuki", model, year, color, isAutomatic, engineVolume, horsepower, price);
        this.allWheelDrive = allWheelDrive;
        this.safetyRating = safetyRating;
    }

    @Override
    public void startEngine() {
        System.out.println("Suzuki " + model + " заводится с кнопки старт/стоп");
    }

    @Override
    public void stopEngine() {
        System.out.println("Suzuki " + model + " двигатель остановлен");
    }

    public void activateAllWheelDrive() {
        if (allWheelDrive) {
            System.out.println("Полный привод активирован");
        } else {
            System.out.println("Данная модель не имеет полного привода");
        }
    }

    public String getSafetyInfo() {
        return "Рейтинг безопасности Suzuki " + model + ": " + safetyRating;
    }

    // Геттеры
    public boolean isAllWheelDrive() { return allWheelDrive; }
    public String getSafetyRating() { return safetyRating; }
}