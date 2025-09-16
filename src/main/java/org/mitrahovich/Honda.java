package org.mitrahovich;

public class Honda extends Car {
    private boolean ecoMode;
    private int cargoCapacity;
    private boolean laneAssist;

    public Honda(String model, int year, String color, boolean isAutomatic, 
                double engineVolume, int horsepower, double price, 
                boolean ecoMode, int cargoCapacity, boolean laneAssist) {
        super("Honda", model, year, color, isAutomatic, engineVolume, horsepower, price);
        this.ecoMode = ecoMode;
        this.cargoCapacity = cargoCapacity;
        this.laneAssist = laneAssist;
    }

    @Override
    public void startEngine() {
        System.out.println("Honda " + model + " заводится надежно и экономично");
    }

    @Override
    public void stopEngine() {
        System.out.println("Honda " + model + " двигатель остановлен");
    }

    public void activateEcoMode() {
        if (ecoMode) {
            System.out.println("Эко-режим активирован для экономии топлива");
        }
    }

    public String getPracticalityInfo() {
        return "Вместимость багажника: " + cargoCapacity + " л, " +
               "Помощник удержания полосы: " + (laneAssist ? "есть" : "нет") + ", " +
               "Эко-режим: " + (ecoMode ? "есть" : "нет");
    }

    // Геттеры
    public boolean hasEcoMode() { return ecoMode; }
    public int getCargoCapacity() { return cargoCapacity; }
    public boolean hasLaneAssist() { return laneAssist; }
}