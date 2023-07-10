package AdvancedSelenium.DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelWriter {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Testing");

        Object data[][] = {
                {"username","password"},
                {"Arifa",123},
                {"Arifa","Arifa@123"},
                {"Arifa","Arifa@123"},
                {"Arifa","Arifa@123"}
        };

        int rows= data.length;
        int cols = data[0].length;


        for(int i=0;i<rows;i++){
            XSSFRow row = sheet.createRow(i);

            for(int j=0;j<cols;j++){
                XSSFCell cell=row.createCell(j);

                Object value=data[i][j];

                if(value instanceof String)
                    cell.setCellValue((String) value);
            }
        }

        String filePath = "/home/shaiA/selinium/selinium_practise/src/main/java/AdvancedSelenium/ExcelReader/ExcelWriter.xlsx";
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();

        System.out.println("Excel sheet file written successfully.......");
    }
}
