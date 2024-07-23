import org.junit.Test;
import static org.junit.Assert.*;

public class ImageTest {

    @Test
    public void testGettersAndSetters() {
        Images images = new Images();
        images.setSvg("testSvg");
        images.setPng("testPng");

        assertEquals("testSvg", images.getSvg());
        assertEquals("testPng", images.getPng());
    }
}
