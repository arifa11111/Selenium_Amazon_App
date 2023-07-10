package AdvancedSelenium.DataDriven;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;

public class CsvReader {
    public static void main(String[] args) throws IOException, CsvValidationException {

        String file = ("/home/shaiA/selinium/selinium_practise/src/main/java/AdvancedSelenium/ExcelReader/CSVReader.csv");
        CSVReader reader = new CSVReader(new FileReader(file));
        String[] cell;

        try {
            while ((cell = reader.readNext()) != null) {
                for (int i = 0; i < 1; i++) {
                    String menu = cell[i];
                    String price = cell[i + 1];
                    System.out.println(menu + price);
                }
            }
        }catch(Exception e){}
    }
}
