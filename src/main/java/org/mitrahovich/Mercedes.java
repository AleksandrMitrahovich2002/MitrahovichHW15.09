package org.mitrahovich;

public class Mercedes extends Car {
    private boolean airSuspension;
    private boolean nightVision;
    private String interiorMaterial;

    public Mercedes(String model, int year, String color, boolean isAutomatic, 
                   double engineVolume, int horsepower, double price, 
                   boolean airSuspension, boolean nightVision, String interiorMaterial) {
        super("Mercedes", model, year, color, isAutomatic, engineVolume, horsepower, price);
        this.airSuspension = airSuspension;
        this.nightVision = nightVision;
        this.interiorMaterial = interiorMaterial;
    }

    @Override
    public void startEngine() {
        System.out.println("Mercedes " + model + " запускается плавно и бесшумно");
    }

    @Override
    public void stopEngine() {
        System.out.println("Mercedes " + model + " двигатель остановлен");
    }

    public void adjustSuspension(int height) {
        if (airSuspension) {
            System.out.println("Пневмоподвеска отрегулирована на высоту: " + height + " мм");
        }
    }

    public String getComfortInfo() {
        return "Интерьер: " + interiorMaterial + ", Ночное видение: " + 
               (nightVision ? "есть" : "нет") + ", Пневмоподвеска: " + 
               (airSuspension ? "есть" : "нет");
    }

    // Геттеры
    public boolean hasAirSuspension() { return airSuspension; }
    public boolean hasNightVision() { return nightVision; }
    public String getInteriorMaterial() { return interiorMaterial; }
}