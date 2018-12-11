package com.example.ghifary.temperatur;

public class Fahrenheit extends Suhu {
    @Override
    public double calculateSuhu1(double suhu) {
        super.calculateSuhu1(suhu);
        return 5.0/9.0 * (suhu-32);
    }

    @Override
    public double calculateSuhu2(double suhu) {
        super.calculateSuhu2(suhu);
        return 4.0/9.0 * (suhu-32);
    }

    @Override
    public double calculateSuhu3(double suhu) {
        super.calculateSuhu3(suhu);
        return 5.0/9.0 * (suhu-32) + 273;
    }
}
