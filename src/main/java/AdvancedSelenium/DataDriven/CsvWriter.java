package AdvancedSelenium.DataDriven;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvWriter {
    public static void main(String[] args) throws IOException {

        //instantiante writer
        CSVWriter writer = new CSVWriter(new FileWriter("/home/shaiA/selinium/selinium_practise/src/main/java/AdvancedSelenium/DataDriven/CSVWriter.csv"));

        //write data into file
        String data[] = {"country","capital"};
        String data1[] = {"india","delhi"};
        String data2[] = {"turkey","istanbul"};
        String data3[] = {"korea","Seoul"};

//        writer.writeNext(data);
//        writer.writeNext(data1);
//        writer.writeNext(data2);
//        writer.writeNext(data3);

        List list  = new ArrayList(Arrays.asList(data,data1,data2,data3));
        writer.writeAll(list);


        //flush data to create csv file data
        writer.flush();

        System.out.println("data added into file");

    }
}
