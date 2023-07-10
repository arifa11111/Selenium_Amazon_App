package AdvancedSelenium.DataDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {
    public static void main(String[] args) throws IOException {

//        File excelFilePath = new File("/home/shaiA/selinium/selinium_practise/src/main/java/AdvancedSelenium/ExcelReader/ExcelWriter.xlsx");
        String excelFilePath = "/home/shaiA/selinium/selinium_practise/src/main/java/AdvancedSelenium/ExcelReader/ExcelWriter.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFilePath);

        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

        XSSFSheet sheet = workbook.getSheet("Testing"); //workbook.getSheetAt(0)

        int rows = sheet.getLastRowNum();
        int cols = sheet.getRow(1).getLastCellNum();

        for(int i=0;i<rows;i++){
            XSSFRow row = sheet.getRow(i);
            for(int j=0;j<cols;j++){
                XSSFCell cell=row.getCell(j);
                cell.getCellType();
                System.out.println(cell.getStringCellValue());
            }
        }
    }
}
