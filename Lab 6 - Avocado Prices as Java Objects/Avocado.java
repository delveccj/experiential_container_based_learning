import java.util.Date;

public class Avocado {
    
    public double totalVolume;

    // Constructor
    public Avocado(Date date, 
        double averagePrice, 
        double totalVolume, 
        double volume4046, 
        double volume4225,
        double volume4770, 
        double totalBags, 
        double smallBags, 
        double largeBags, 
        double xLargeBags,
        String type, 
        int year, 
        String region) {
        this.totalVolume = totalVolume;
    }

    public double getTotalVolume(){
        return totalVolume;
    }

}
