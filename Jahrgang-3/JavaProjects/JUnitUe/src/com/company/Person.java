package com.company;

public class Person {
    private String vn;
    private String nn;
    private int ff=0;

    public Person(String vn, String nn, int ff){
        this.ff=ff;
        this.nn=nn;
        this.vn=vn;
    }

    public String toString(){
        return String.format("%s, %s, %d",this.nn, this.vn, this.ff  );
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getNn() {
        return nn;
    }

    public void setNn(String nn) {
        this.nn = nn;
    }
}
