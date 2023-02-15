import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {
    @Test
    void testCheckBarcode() {
        assertEquals(true, Article.checkBarcode(73513535));

        assertEquals(true, Article.checkBarcode(12345678));

        assertEquals(true, Article.checkBarcode(11223342));

        assertEquals(false, Article.checkBarcode(19741997));
        assertEquals(false, Article.checkBarcode(73513536));

        //too long or short:
        assertEquals(false, Article.checkBarcode(12342));
        assertEquals(false, Article.checkBarcode(2321341));
        assertEquals(false, Article.checkBarcode(232134131));
        assertEquals(false, Article.checkBarcode(1234567890));
    }

    @Test
    void testClassIsAbstract() {
        assertEquals(true, Modifier.isAbstract(Article.class.getModifiers()));
    }
}