import java.util.List;

public class DeckResponse {

    private boolean success;
    private String deck_id;
    //variables

    // Getters
    public boolean isSuccess() {
        return success;
    }

    public String getDeck_id() {
        return deck_id;
    }

    // Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }


}