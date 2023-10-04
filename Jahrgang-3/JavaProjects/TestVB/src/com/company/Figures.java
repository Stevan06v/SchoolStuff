package com.company;

public abstract class Figures {
    int x;
    int y;

    public Figures(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public abstract double flaeche();
}
