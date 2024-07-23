import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.theokanning.openai.completion.chat.ChatCompletionChoice;
import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import io.reactivex.Flowable;

public class LabFour{

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Welcome to Lab 4!");
        exampleOfDocumentAsContext();
        String speechText = getSpeechText();
        createChatAgentWithContext(speechText, "Whom did the speaker address?");
        createChatAgentWithContext(speechText, "Why is 1832 an important year?");
        createChatAgentWithContext(speechText, "What does the speaker want the audience to know about the 1976 election??");
    }

    private static void createChatAgentWithContext(String speechText, String user_question) {
        OpenAiService service = new OpenAiService("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");
        System.out.println("Streaming chat completion...");
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "{" + speechText + "}\n\n{" + user_question + "}");
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .temperature(0.0)
                .build();

                service.streamChatCompletion(chatCompletionRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(chatCompletion ->
                {
                    List<ChatCompletionChoice> choices = chatCompletion.getChoices();
                     // Task 2
                    for(ChatCompletionChoice choice : choices){
                        System.out.print(choice.getMessage().getContent());
                    }
                }
                );
        System.out.println();

        service.shutdownExecutor();

    }

    public static String getSpeechText(){
        // This is Task 1 - you need to read in speech.txt and return it as a String!
        String filename = "speech.txt"; // specify the path to your file
        String fileContent = "";
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(filename)));
            //System.out.println("File content:\n" + fileContent);
        } catch (IOException e) {
            e.printStackTrace();
        }return fileContent;
    }

    // How to send a document as context
    // combined_text = "{document_text}\n\n{user_question}"

    private static void exampleOfDocumentAsContext() {
        OpenAiService service = new OpenAiService("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");
        System.out.println("Streaming chat completion...");
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "{Rufus is a dog.  He is a big shaggy dog.  His coat of fur is colored purple!  Rufus is a purple purple dog!}\n\n{What color is Rufus?}");
        messages.add(systemMessage);
        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo")
                .messages(messages)
                .n(1)
                .maxTokens(50)
                .logitBias(new HashMap<>())
                .build();

        service.streamChatCompletion(chatCompletionRequest)
                .doOnError(Throwable::printStackTrace)
                .blockingForEach(chatCompletion ->
                {
                    List<ChatCompletionChoice> choices = chatCompletion.getChoices();
                    for(ChatCompletionChoice choice : choices){
                        
                    }
                    // THis is Task 2.  You need to print out a nice, natural language sentence.
                }
                );
        System.out.println();
        service.shutdownExecutor();


        
    }


}
