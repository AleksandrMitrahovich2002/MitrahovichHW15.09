package org.mitrahovich;

public class Toyota extends Car {
    private int warrantyYears;
    private boolean hybridSystem;
    private double fuelConsumption;

    public Toyota(String model, int year, String color, boolean isAutomatic, 
                 double engineVolume, int horsepower, double price, 
                 int warrantyYears, boolean hybridSystem, double fuelConsumption) {
        super("Toyota", model, year, color, isAutomatic, engineVolume, horsepower, price);
        this.warrantyYears = warrantyYears;
        this.hybridSystem = hybridSystem;
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public void startEngine() {
        if (hybridSystem) {
            System.out.println("Toyota " + model + " запускается в бесшумном электро-режиме");
        } else {
            System.out.println("Toyota " + model + " двигатель запущен");
        }
    }

    @Override
    public void stopEngine() {
        System.out.println("Toyota " + model + " двигатель остановлен");
    }

    public String getWarrantyInfo() {
        return "Гарантия: " + warrantyYears + " лет или 100,000 км";
    }

    public double calculateAnnualFuelCost(double kmPerYear, double fuelPrice) {
        return (kmPerYear / 100) * fuelConsumption * fuelPrice;
    }

    // Геттеры
    public int getWarrantyYears() { return warrantyYears; }
    public boolean isHybridSystem() { return hybridSystem; }
    public double getFuelConsumption() { return fuelConsumption; }
}