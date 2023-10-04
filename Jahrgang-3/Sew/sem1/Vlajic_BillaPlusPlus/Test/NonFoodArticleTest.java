import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NonFoodArticleTest {
    @Test
    void testConstructor() {
        NonFoodArticle raspberry = new NonFoodArticle("Raspberry Pi", 45342323, 20, 24);
        assertEquals("Raspberry Pi", raspberry.getArticleName());
        assertEquals(45342323, raspberry.getBarcode());
        assertEquals(20, raspberry.getQuantity());
        assertEquals(24, raspberry.getWarrantyMonths());
    }

    @Test
    void testConstructorNegativeQuantity() {
        NonFoodArticle raspberry = new NonFoodArticle("Raspberry Pi", 45342323, 0, 24);
        assertEquals("Raspberry Pi", raspberry.getArticleName());
        assertEquals(45342323, raspberry.getBarcode());
        assertEquals(0, raspberry.getQuantity());
        assertEquals(24, raspberry.getWarrantyMonths());

        raspberry = new NonFoodArticle("Raspberry Pi", 45342323, -1, 24);
        assertEquals("Raspberry Pi", raspberry.getArticleName());
        assertEquals(45342323, raspberry.getBarcode());
        assertEquals(0, raspberry.getQuantity());
        assertEquals(24, raspberry.getWarrantyMonths());

        raspberry = new NonFoodArticle("Raspberry Pi", 45342323, -1234, 24);
        assertEquals("Raspberry Pi", raspberry.getArticleName());
        assertEquals(45342323, raspberry.getBarcode());
        assertEquals(0, raspberry.getQuantity());
        assertEquals(24, raspberry.getWarrantyMonths());
    }

    @Test
    void testConstructorNegativeWarrantyMonths() {
        NonFoodArticle raspberry = new NonFoodArticle("Raspberry Pi", 45342323, 20, 0);
        assertEquals("Raspberry Pi", raspberry.getArticleName());
        assertEquals(45342323, raspberry.getBarcode());
        assertEquals(20, raspberry.getQuantity());
        assertEquals(0, raspberry.getWarrantyMonths());

        raspberry = new NonFoodArticle("Raspberry Pi", 45342323, 20, -1);
        assertEquals("Raspberry Pi", raspberry.getArticleName());
        assertEquals(45342323, raspberry.getBarcode());
        assertEquals(20, raspberry.getQuantity());
        assertEquals(0, raspberry.getWarrantyMonths());

        raspberry = new NonFoodArticle("Raspberry Pi", 45342323, 20, -70);
        assertEquals("Raspberry Pi", raspberry.getArticleName());
        assertEquals(45342323, raspberry.getBarcode());
        assertEquals(20, raspberry.getQuantity());
        assertEquals(0, raspberry.getWarrantyMonths());
    }
}