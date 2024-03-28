package com.ohgiraffers.InBody;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class BMI {

    @Column(name = "height")
    private double height;
    @Column(name = "weight")
    private double weight;
    @Column(name = "BMI")
    private double bmi;

    protected BMI() {}

    public BMI(double height, double weight) {
        this.height = height;
        this.weight = weight;
        this.bmi = calculateBMI(height,weight);
    }

    private double calculateBMI(double height, double weight) {
        return weight/(Math.pow(height/100,2));                     // BMI 계산하는 공식
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return "BMI{" +
                "height=" + height +
                ", weight=" + weight +
                ", bmi=" + bmi +
                '}';
    }
}
