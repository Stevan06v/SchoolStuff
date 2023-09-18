package com.company;

import java.util.Objects;

public class Square extends Figures{
    double length;
    double width;
    public Square(double length, double width, int x, int y) {
        super(x,y);
        this.length = length;
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Double.compare(square.length, length) == 0
                && Double.compare(square.width, width) == 0
                || Double.compare(square.length, width) == 0
                && Double.compare(square.width, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }

    @Override
    public String toString() {
        return String.format("Square with %.2f/%.2f at (%d/%d)", this.length, this.width, super.x, super.y);
    }

    @Override
    public double flaeche(){
        return this.length * this.width;
    }


    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }


}
