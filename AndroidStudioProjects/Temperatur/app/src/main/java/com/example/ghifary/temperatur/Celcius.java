package com.example.ghifary.temperatur;

public class Celcius extends Suhu{
    @Override
    public double calculateSuhu1(double suhu) {
        super.calculateSuhu1(suhu);
        return 0.4/0.5 * suhu;
    }

    @Override
    public double calculateSuhu2(double suhu) {
        super.calculateSuhu2(suhu);
        return (9.0/5.0) * suhu +32;
    }

    @Override
    public double calculateSuhu3(double suhu) {
        super.calculateSuhu3(suhu);
        return suhu + 273;
    }
}
