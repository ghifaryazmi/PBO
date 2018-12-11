package com.example.ghifary.temperatur;

public class Kelvin extends Suhu {
    @Override
    public double calculateSuhu1(double suhu) {
        super.calculateSuhu1(suhu);
        return suhu - 273;
    }

    @Override
    public double calculateSuhu2(double suhu) {
        super.calculateSuhu2(suhu);
        return 4.0/5.0 * (suhu-273);
    }

    @Override
    public double calculateSuhu3(double suhu) {
        super.calculateSuhu3(suhu);
        return 9.0/5.0 * (suhu-273) + 32;
    }
}
