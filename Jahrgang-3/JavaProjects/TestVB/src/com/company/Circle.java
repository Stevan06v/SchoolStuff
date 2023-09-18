package com.company;

import java.util.Objects;

public class Circle extends Figures{
    double radius;

    public Circle(double radius, int x, int y) {
        super(x,y);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return String.format("Circle with radius=%.2f at (%d/%d)", this.radius, super.x, super.y);
    }

    @Override
    public double flaeche(){
        return Math.pow(this.radius, 2)*Math.PI;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
