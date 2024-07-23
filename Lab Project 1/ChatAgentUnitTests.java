import static org.junit.Assert.*;
import org.junit.Test;

public class ChatAgentUnitTests {

    @Test
    public void testConstantsAreSpecified() {
        assertEquals(0, ChatAgentPrototype.EPISODE_1);
        assertEquals(1, ChatAgentPrototype.EPISODE_2);
    }

    @Test
    public void testGetTranscipts() {
        String[] transcripts = ChatAgentPrototype.getTranscripts();
        assertEquals(2,transcripts.length);
        assertTrue("Transcript 1 starts with unexpected content", transcripts[0].startsWith("Every year at this time I place a call to a leading investment "));
        assertTrue("Transcript 2 starts with unexpected content", transcripts[1].startsWith("Hello and welcome to this WealthTrack podcast. I'm Consuelo Mack."));
    }
}