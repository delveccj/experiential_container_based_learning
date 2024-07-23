import com.fasterxml.jackson.databind.*;

public class DeckDriver {


    public static void main(String[] args) throws Exception{
        String jsonString = "{\"success\": true, \"deck_id\": \"phaxugv7a7l4\", \"cards\": [{\"code\": \"7C\", \"image\": \"https://deckofcardsapi.com/static/img/7C.png\", \"images\": {\"svg\": \"https://deckofcardsapi.com/static/img/7C.svg\", \"png\": \"https://deckofcardsapi.com/static/img/7C.png\"}, \"value\": \"7\", \"suit\": \"CLUBS\"}, {\"code\": \"0H\", \"image\": \"https://deckofcardsapi.com/static/img/0H.png\", \"images\": {\"svg\": \"https://deckofcardsapi.com/static/img/0H.svg\", \"png\": \"https://deckofcardsapi.com/static/img/0H.png\"}, \"value\": \"10\", \"suit\": \"HEARTS\"}], \"remaining\": 206}";
        System.out.println("Using deck_id");
        ObjectMapper mapper = new ObjectMapper();
        DeckResponse response = mapper.readValue(jsonString, DeckResponse.class);
    }

    
}
