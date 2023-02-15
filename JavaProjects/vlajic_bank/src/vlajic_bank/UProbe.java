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
public class UProbe {
    private boolean checked;
    private int ktoNr;
    
    public UProbe(int ktoNr, boolean checked){
    this.ktoNr=ktoNr;
    this.checked=checked;
 
    }
    
    public String toString (){
        return "Unterschrift wurde "+
                ((checked) ? "" : "nicht ")+
                "überprüft";
   
    }
}
