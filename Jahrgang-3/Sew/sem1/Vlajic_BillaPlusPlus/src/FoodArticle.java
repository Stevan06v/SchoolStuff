import java.util.*;


public class FoodArticle extends Article{

    private HashSet<AllergenType> allergens = new HashSet<AllergenType>();

    public FoodArticle(String articleName, int barcode, int quantity, AllergenType[] types) {
        super(articleName, barcode, quantity);
        allergens.addAll(List.of(types));
    }
    public boolean removeAllergen(AllergenType f){
        if(allergens.contains(f)){
            allergens.remove(f);
            return true;
        }
        return false;

    }

    public boolean addAllergen(AllergenType a){
        if(!allergens.contains(a)){
            allergens.add(a);
            return true;
        }
        return false;
    };

    public boolean containsAnyAllergen(AllergenType[] allergenTypes){
        for (AllergenType iterator : allergenTypes) {
            if(this. allergens.contains(iterator)){
                return true;
            }
        }
        return false;
    }



}
