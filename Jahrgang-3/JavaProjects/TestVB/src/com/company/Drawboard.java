package com.company;

public class Drawboard {
    int anz;
    Figures[] figures;

    public Drawboard(int anz) {
        this.anz = anz;
        figures= new Figures[anz];
    }

    public boolean addFigure(Figures f){
        for (int i = 0; i < this.figures.length; i++) {
            if(this.figures[i] == null){
                figures[i]=f;
                return true;
            }
        }
        return false;
    }

    public double calculateSurface(){
        double sum = 0.0;
        for (int i = 0; i < this.figures.length; i++) {
            if(this.figures[i] != null){
                sum += this.figures[i].flaeche();
            }
        }
        return sum;
    }

    public void printAll() {
        for (int i = 0; i < this.figures.length; i++) {
            if (this.figures[i] != null) {
                System.out.println(this.figures[i].toString());
            }
        }
    }
    public void printCountOfGroups(){
        for (int i = 0; i < this.figures.length && this.figures[i] != null; i++) {
            boolean isFirst=true;
                //bereits vorher ausgegeben ja contginue
                for (int j = 0; j < i; j++) {
                    if(this.figures[i].equals(figures[i])){
                        isFirst = false;
                        break;
                    }
                }
            if(!isFirst){
                int counter =1;
                for (int j = i+1; j < this.figures.length; j++) {
                    if(figures[i].equals(figures[j])){
                        counter++;
                    }
                }
                System.out.println(counter + " " + this.toString());
            }
        }
    }



}
