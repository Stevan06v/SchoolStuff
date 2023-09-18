/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vlajic_bank;

/**
 *
 * @author stevan
 */
public class Person {

    private String nName;
    private String vName;
    private String titel;
    private String ort;
    private String place;
    private String straße;

    public Person(String vName, String nName,String titel,String ort,String place,String straße) {
        this.nName=nName;
        this.vName=vName;
        this.ort=ort;
        this.place=place;
        this.straße=straße;
        
    }
    
    public toString(){
        return String.format("%s","%s","%s",getnName());
    }
}
