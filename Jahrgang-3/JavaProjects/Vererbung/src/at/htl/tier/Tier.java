package at.htl.tier;

public class Tier {
    private String name;
    protected double gewicht;
    private int fluegelspannweite;

    public Tier(String name, double gewicht){
        setGewicht(gewicht);
        setName(name);
    }

    public Tier(){

    }

    public String toString(){
        return String.format("%s %.1fkg", name, gewicht);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }
}
