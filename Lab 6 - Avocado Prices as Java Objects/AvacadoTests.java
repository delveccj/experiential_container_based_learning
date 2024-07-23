import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class AvacadoTests {
    public static void main(String[] args){
        AvocadoDriver.main(null);
        int size = AvocadoDriver.getAvocadoList().size();
        // The file path
        String filePath = "output.txt";

        // Write the string to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Size of list is: " + size);
        } catch (IOException e) {
            e.printStackTrace();
        }

        double sum = 0.0;
        boolean notNull = true;
        if(AvocadoDriver.getAvocadoList().size() == 0){
            notNull = false;            
        }
        for(Avocado avocado : AvocadoDriver.getAvocadoList()){
            if(avocado == null){
                notNull = false;
            } 
            else{
                sum = sum + avocado.getTotalVolume();
            }

        }
        String filePath2 = "output2.txt";

        // Write the string to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath2))) {
            writer.write(notNull + "");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath3 = "output3.txt";

        // Write the string to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath3))) {
            writer.write(sum + "");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
