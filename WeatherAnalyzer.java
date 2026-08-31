import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherAnalyzer {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        // Main program logic
        String[][] data = readCSV(args[0]);
        // for (int i = 0; i < data.length; i++) {
        //     for (int j = 0; j < data[i].length; j++) {
        //         System.out.println(data[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println("what column would u like to analyze\n1 - High Temp (f)\n2 - Low Temp (f)\n3 - Humidity\n4 - Wind Speed (mph)\n5 - Precipitation (inches)");
        int columnChoice = input.nextInt();

        double[] columnValues = extractNumericColumn(data, columnChoice);
        for (int i = 0; i < columnValues.length; i++) {
            System.out.println(columnValues[i]);
        }
        displayStatistics(columnValues, data[0][columnChoice]);
        
    }

    public static String[][] readCSV(String filename) {
        // Read and parse CSV file
        StringBuilder str = new StringBuilder();
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(filename));
            
            String line;
            while ((line = br.readLine()) != null) {               
                str.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("File not found :(");
            System.exit(1);
        } 
        String[] lines = str.toString().split("\n");
        String[][] data = new String[lines.length][6];


        for (int i = 0; i < lines.length; i++) {
            String[] elements = lines[i].split(",");
            for (int j = 0; j < 6; j++) {
                data[i][j] = elements[j];
            }
        }

        return data;
        
    }

    public static double[] extractNumericColumn(String[][] data, int columnIndex) {
        // Extract and validate numeric data from specified column
        double[] columnValues = new double[data.length];
        for (int i = 1; i < data.length; i++) {
            columnValues[i] = Double.parseDouble(data[i][columnIndex]);
        }
        return columnValues;
    }

    public static void displayStatistics(double[] values, String columnName) {
        // Calculate and display all required statistics
        double total = 0;
        double max = -1000000000;
        double min = 100000000;
        int valueTotal = 0;
        for (int i = 1; i < values.length; i++) {
            total += values[i];
            if (values[i] > max) {
                max = values[i];
            }
            if (values[i] < min) {
                min = values[i];
            }
            valueTotal++;
        }

        double average = total / (values.length - 1);

        System.out.println("Average of " + columnName + ": " + average);
        System.out.println("Highest Value of " + columnName + ": " + max);
        System.out.println("Lowest Value of " + columnName + ": " + min);
        System.out.println("number of data points processed: " + valueTotal);
    }
}
