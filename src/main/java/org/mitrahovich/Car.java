package org.mitrahovich;

import java.util.Objects;

public abstract class Car {
    protected String brand;
    protected String model;
    protected int year;
    protected String color;
    protected boolean isAutomatic;
    protected double engineVolume;
    protected int horsepower;
    protected double price;

    // Конструктор
    public Car(String brand, String model, int year, String color, 
               boolean isAutomatic, double engineVolume, int horsepower, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.isAutomatic = isAutomatic;
        this.engineVolume = engineVolume;
        this.horsepower = horsepower;
        this.price = price;
    }

    // Абстрактные методы
    public abstract void startEngine();
    public abstract void stopEngine();

    // Методы для получения информации
    public String getFullInfo() {
        return String.format("Марка: %s, Модель: %s, Год: %d, Цвет: %s, " +
                           "Коробка: %s, Объем: %.1f л, Мощность: %d л.с., Цена: $%.2f",
                           brand, model, year, color, 
                           isAutomatic ? "Автомат" : "Механика", 
                           engineVolume, horsepower, price);
    }

    public String getTechnicalInfo() {
        return String.format("Технические характеристики: %s %s, %.1f л, %d л.с., %s",
                           brand, model, engineVolume, horsepower,
                           isAutomatic ? "автоматическая коробка" : "механическая коробка");
    }

    // Методы для изменения свойств
    public void changeColor(String newColor) {
        this.color = newColor;
        System.out.println("Цвет изменен на: " + newColor);
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
        System.out.println("Цена обновлена: $" + newPrice);
    }

    // Геттеры и сеттеры
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public int getYear() { return year; }
    public String getColor() { return color; }
    public boolean isAutomatic() { return isAutomatic; }
    public double getEngineVolume() { return engineVolume; }
    public int getHorsepower() { return horsepower; }
    public double getPrice() { return price; }

    public void setColor(String color) { this.color = color; }
    public void setPrice(double price) { this.price = price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && 
               isAutomatic == car.isAutomatic &&
               Double.compare(car.engineVolume, engineVolume) == 0 &&
               horsepower == car.horsepower &&
               Double.compare(car.price, price) == 0 &&
               Objects.equals(brand, car.brand) &&
               Objects.equals(model, car.model) &&
               Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, color, isAutomatic, engineVolume, horsepower, price);
    }

    @Override
    public String toString() {
        return getFullInfo();
    }
}