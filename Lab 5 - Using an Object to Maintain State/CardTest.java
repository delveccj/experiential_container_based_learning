import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void testGettersAndSetters() {
        Card card = new Card();
        card.setCode("testCode");
        card.setImage("testImage");
        Images images = new Images();
        images.setSvg("testSvg");
        images.setPng("testPng");
        card.setImages(images);
        card.setValue("testValue");
        card.setSuit("testSuit");

        assertEquals("testCode", card.getCode());
        assertEquals("testImage", card.getImage());
        assertEquals("testSvg", card.getImages().getSvg());
        assertEquals("testPng", card.getImages().getPng());
        assertEquals("testValue", card.getValue());
        assertEquals("testSuit", card.getSuit());
    }
}
