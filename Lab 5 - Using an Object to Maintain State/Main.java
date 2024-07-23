import com.fasterxml.jackson.databind.*;

public class Main {

    public static void main(String[] args) throws Exception{
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello, Welcome to Lanb 7");
        String json = "{\"name\": \"John\", \"age\": 30}";
        
        // Create ObjectMapper instance
        ObjectMapper mapper = new ObjectMapper();
        // Convert JSON to Java object
        Person person = mapper.readValue(json, Person.class);
        
        // Print the Java object
        System.out.println(person.getName()); // John
        System.out.println(person.getAge());  // 30
    }
}
