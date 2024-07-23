import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class DeckResponseTest {

    @Test
    public void testGettersAndSetters() {
        DeckResponse deckResponse = new DeckResponse();
        deckResponse.setSuccess(true);
        deckResponse.setDeck_id("testDeckId");
        List<Card> cards = new ArrayList<>();
        Card card1 = new Card();
        card1.setCode("testCode1");
        card1.setImage("testImage1");
        Images images1 = new Images();
        images1.setSvg("testSvg1");
        images1.setPng("testPng1");
        card1.setImages(images1);
        card1.setValue("testValue1");
        card1.setSuit("testSuit1");
        cards.add(card1);
        Card card2 = new Card();
        card2.setCode("testCode2");
        card2.setImage("testImage2");
        Images images2 = new Images();
        images2.setSvg("testSvg2");
        images2.setPng("testPng2");
        card2.setImages(images2);
        card2.setValue("testValue2");
        card2.setSuit("testSuit2");
        cards.add(card2);
        deckResponse.setCards(cards);
        deckResponse.setRemaining(100);

        assertEquals(true, deckResponse.isSuccess());
        assertEquals("testDeckId", deckResponse.getDeck_id());
        assertEquals("testCode1", deckResponse.getCards().get(0).getCode());
        assertEquals("testImage1", deckResponse.getCards().get(0).getImage());
        assertEquals("testSvg1", deckResponse.getCards().get(0).getImages().getSvg());
        assertEquals("testPng1", deckResponse.getCards().get(0).getImages().getPng());
        assertEquals("testValue1", deckResponse.getCards().get(0).getValue());
        assertEquals("testSuit1", deckResponse.getCards().get(0).getSuit());
        assertEquals("testCode2", deckResponse.getCards().get(1).getCode());
        assertEquals("testImage2", deckResponse.getCards().get(1).getImage());
        assertEquals("testSvg2", deckResponse.getCards().get(1).getImages().getSvg());
        assertEquals("testPng2", deckResponse.getCards().get(1).getImages().getPng());
        assertEquals("testValue2", deckResponse.getCards().get(1).getValue());
        assertEquals("testSuit2", deckResponse.getCards().get(1).getSuit());
        assertEquals(100, deckResponse.getRemaining());
    }
}
