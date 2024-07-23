import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to Project One!");
        System.out.println(System.getProperty("java.class.path"));
        getCompletionRequest();
    }

    private static void getCompletionRequest() {
        OpenAiService service = new OpenAiService("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");
        CompletionRequest completionRequest = CompletionRequest.builder()
            .prompt("What temoperature does water freeze at.  Give me the answer in both F and C.")
            .model("babbage-002")
            .echo(true)
            .temperature(0.0)
            .build();
        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
    }

}
