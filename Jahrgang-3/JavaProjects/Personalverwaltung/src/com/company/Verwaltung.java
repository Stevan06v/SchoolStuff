package com.company;

public class Verwaltung {
    Mitarbeiter[] ma;


    public Verwaltung(int maxAnz){
        ma = new Mitarbeiter[maxAnz];
    }

    public Verwaltung(Mitarbeiter[]m){
        this.ma=m;
    }

    public boolean addMitarbeiter(Mitarbeiter ma){
        for (int i = 0; i < this.ma.length; i++) {
            if (this.ma[i] == null) {
                this.ma[i] = ma;
                return true;
            }
        }
        return false;
    }


    public boolean removeMitarbeiter(Mitarbeiter ma){
        for (int i = 0; i < this.ma.length; i++) {
            if(this.ma[i] != null && this.ma[i] == ma){
                this.ma[i]=null;
                //5
                //length = 10
                for(int j = i; j < this.ma.length-1; j++) {
                    this.ma[j]=this.ma[j+1];
                }
                this.ma[this.ma.length-1] = null;
            }
            return true;
        }
        return false;
    }


    public void listMitarbeiter(){
        for (int i = 0; i < this.ma.length; i++) {
            if(this.ma[i] != null){
                System.out.println(this.ma[i].tostring());
            }
        }
    }


    public String listMitarbeiterString(){
        String save="\n";
        for (int i = 0; i < this.ma.length; i++) {
            if(this.ma[i] != null){
             save+=this.ma[i].tostring() +"\n";
            }
        }
        return save;
    }

    public void sortMitarbeiter(){
        int[]arr= new int[this.ma.length];
        for (int i = 0; i < this.ma.length; i++) {
            if(this.ma[i]!=null){
                arr[i]=ma[i].id;
            }
        }
        Mitarbeiter temp;
        for (int i = 0; i < this.ma.length-1; i++) {
            for (int j = 0; j < this.ma.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    temp = ma[j];
                    ma[j]= ma[j+1];
                    ma[j+1]= temp;
                }
            }
        }
    }


}
