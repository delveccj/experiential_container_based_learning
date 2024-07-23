import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AvocadoDriver {

    private static ArrayList<Avocado> avacadosList = new ArrayList<Avocado>();

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Welcome to Lab 7");
        String csvFile = "avocado.csv";
        String line = "";
        String csvSplitBy = ",";


        String pattern = "yyyy-MM-dd";
        // Create a SimpleDateFormat object with the specified pattern
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                // Process each row here
                for (String value : data) {
                    System.out.print(value + "\t");
                }
                // Parse the string into a Date object
                Date date;
                try {
                    date = sdf.parse(data[1]);
                    System.out.println("Parsed Date: " + date);
                    Avocado avocado = new Avocado(
                        date, 
                        Double.parseDouble(data[2]), 
                        Double.parseDouble(data[3]), 
                        Double.parseDouble(data[4]), 
                        Double.parseDouble(data[5]), 
                        Double.parseDouble(data[6]), 
                        Double.parseDouble(data[7]), 
                        Double.parseDouble(data[8]), 
                        Double.parseDouble(data[9]), 
                        Double.parseDouble(data[10]), 
                        data[11],
                        Integer.parseInt(data[12]),
                        data[13]
                        );
                    avacadosList.add(avocado);
    
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                // Task 2: You need to populate avacadosList (the static variable at top)
                // with Avocado objects that represent the CSV lines
                System.out.println(); // Move to the next line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Avocado> getAvocadoList(){
        return avacadosList;
    }

}
