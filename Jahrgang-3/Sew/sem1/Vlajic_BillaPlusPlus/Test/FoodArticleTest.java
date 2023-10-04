import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodArticleTest {
    @Test
    public void testInheritance() {
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals(true, tofu instanceof Article);
    }

    @Test
    public void testConstructor() {
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals("Tofu", tofu.getArticleName());
        assertEquals(12345678, tofu.getBarcode());
        assertEquals(100, tofu.getQuantity());
    }

    @Test
    void testConstructorNegativeQuantity() {
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 0, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals("Tofu", tofu.getArticleName());
        assertEquals(12345678, tofu.getBarcode());
        assertEquals(0, tofu.getQuantity());

        tofu = new FoodArticle("Tofu", 12345678, -1, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals("Tofu", tofu.getArticleName());
        assertEquals(12345678, tofu.getBarcode());
        assertEquals(0, tofu.getQuantity());

        tofu = new FoodArticle("Tofu", 12345678, -999, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals("Tofu", tofu.getArticleName());
        assertEquals(12345678, tofu.getBarcode());
        assertEquals(0, tofu.getQuantity());
    }

    @Test
    public void testAddAllergen() {
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals(true, tofu.addAllergen(AllergenType.A));
        assertEquals(false, tofu.addAllergen(AllergenType.L));
        assertEquals(false, tofu.addAllergen(AllergenType.A));
    }

    @Test
    public void testRemoveAllergen() {
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals(false, tofu.removeAllergen(AllergenType.A));
        assertEquals(true, tofu.removeAllergen(AllergenType.F));
        assertEquals(false, tofu.removeAllergen(AllergenType.F));
    }

    @Test
    public void testContainsAnyAllergen() {
        FoodArticle tofu = new FoodArticle("Tofu", 12345678, 100, new AllergenType[] {AllergenType.F,AllergenType.L});
        assertEquals(true,tofu.containsAnyAllergen(new AllergenType[] {AllergenType.F,AllergenType.L}));
        assertEquals(true,tofu.containsAnyAllergen(new AllergenType[] {AllergenType.F}));
        assertEquals(true,tofu.containsAnyAllergen(new AllergenType[] {AllergenType.L}));

        assertEquals(false,tofu.containsAnyAllergen(new AllergenType[] {AllergenType.D}));
        assertEquals(false,tofu.containsAnyAllergen(new AllergenType[] {AllergenType.D, AllergenType.E, AllergenType.M}));

        assertEquals(true,tofu.containsAnyAllergen(new AllergenType[] {AllergenType.D,AllergenType.L}));
        assertEquals(true,tofu.containsAnyAllergen(new AllergenType[] {AllergenType.D, AllergenType.F, AllergenType.M, AllergenType.N}));
    }

}