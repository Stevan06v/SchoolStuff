package com.company;

public class Kreis extends Object{
    private int rad;

    public Kreis(int rad) {
        this.rad = rad;
    }

    public double umfang(){
        return 2*rad*Math.PI;
    }

    public  double flaeche(){
        return Math.pow(rad, 2)*Math.PI;
    }

    public int getRad() {
        return rad;
    }

    public void setRad(int rad) {
        this.rad = rad;
    }
}
