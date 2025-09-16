package org.mitrahovich;

public class BMW extends Car {
    private boolean sportPackage;
    private String driveType; // RWD, AWD
    private boolean hasPremiumSound;

    public BMW(String model, int year, String color, boolean isAutomatic, 
              double engineVolume, int horsepower, double price, 
              boolean sportPackage, String driveType, boolean hasPremiumSound) {
        super("BMW", model, year, color, isAutomatic, engineVolume, horsepower, price);
        this.sportPackage = sportPackage;
        this.driveType = driveType;
        this.hasPremiumSound = hasPremiumSound;
    }

    @Override
    public void startEngine() {
        System.out.println("BMW " + model + " заводится с характерным спортивным звуком");
    }

    @Override
    public void stopEngine() {
        System.out.println("BMW " + model + " двигатель остановлен");
    }

    public void activateSportMode() {
        if (sportPackage) {
            System.out.println("Спортивный режим активирован");
        } else {
            System.out.println("Спортивный пакет не установлен");
        }
    }

    public String getDriveTypeInfo() {
        return "Тип привода: " + driveType;
    }

    // Геттеры
    public boolean isSportPackage() { return sportPackage; }
    public String getDriveType() { return driveType; }
    public boolean hasPremiumSound() { return hasPremiumSound; }
}