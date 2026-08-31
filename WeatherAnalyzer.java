import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WeatherAnalyzer {

    public static void main(String[] args) {
        // Main program logic
        readCSV(args[0]);
    }

    public static void readCSV(String filename) {
        // Read and parse CSV file
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("error reading file");
            System.exit(1);
        } 
    }

    //public static _______ extractNumericColumn(_____ data, int columnIndex) {
        // Extract and validate numeric data from specified column
    //}

    public static void displayStatistics(double[] values, String columnName) {
        // Calculate and display all required statistics
    }
}
