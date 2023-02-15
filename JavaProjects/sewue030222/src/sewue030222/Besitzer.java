/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sewue030222;
/**
 *
 * @author steva
 */
public class Besitzer {

    private String name;
    private Tier[] tier;

    public Besitzer(int max) {
        tier = new Tier[max];
    }

    public boolean kauft(Tier tier) {
        for (int i = 0; i < this.tier.length; i++) {
            if (this.tier[i] == null) {
                this.tier[i] = tier;
                tier.setOwner(this);
                return true;
            }
        }
        return false;
    }
    
   
    

    public Besitzer(String name) {
        this(5);
        setName(name);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the tier
     */
    public Tier[] getTier() {
        return tier;
    }

    /**
     * @param tier the tier to set
     */
}
