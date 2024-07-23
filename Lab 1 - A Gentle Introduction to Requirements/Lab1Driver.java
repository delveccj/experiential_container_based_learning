// You will need imports for sure!
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lab1Driver {

    public static void main(String[] args) {
        String answerOne = runOpenAPIHttpOnlyConnection(args[0], args[1]);
        System.out.println(answerOne);
    }

    public static String runOpenAPIHttpOnlyConnection(String prompt, String temperature){
        String url = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiKey);
            connection.setRequestProperty("Content-Type", "application/json");

            // The request body
            String body = "{\"model\": \"" + model + "\", \"temperature\": " + temperature + ", \"messages\": [{\"role\": \"user\", \"content\": \"" + prompt + "\"}]}";
            connection.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
            writer.write(body);
            writer.flush();
            writer.close();

            // Response from ChatGPT
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;

            StringBuffer response = new StringBuffer();

            while ((line = br.readLine()) != null) {
                response.append(line);
            }
            br.close();

            // calls the method to extract the message.
            return extractMessageFromJSONResponse(response.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String extractMessageFromJSONResponse(String response) {
        int start = response.indexOf("content")+ 11;

        int end = response.indexOf("\"", start);

        return response.substring(start, end);

    }

}
