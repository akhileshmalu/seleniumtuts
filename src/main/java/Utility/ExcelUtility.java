package Utility;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * @author: Akhilesh Maloo
 * @date: 2/5/18.
 */
public class ExcelUtility {

    private static XSSFSheet sheet;
    private static XSSFCell cell;
    private static XSSFWorkbook workBook;
    private static XSSFRow row;
    private static FileInputStream excelFile;
    private static FileOutputStream outFile;

    public static void setExcelFile(String path, String sheetName) {

        try {
            excelFile = new FileInputStream(path);
            workBook = new XSSFWorkbook(excelFile);
            sheet = workBook.getSheet(sheetName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getCellData(int rowNum, int colNum) throws Exception {
        cell = sheet.getRow(rowNum).getCell(colNum);
        return cell.getStringCellValue();
    }

    public static void setCellData(String data, int rowNum, int colNum) throws Exception {

        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum, Row.RETURN_BLANK_AS_NULL);

        if (cell == null)
            cell = row.createCell(colNum);

        cell.setCellValue(data);

        outFile = new FileOutputStream("TestData/testData.xlsx");
        workBook.write(outFile);
        outFile.flush();
        outFile.close();

    }


}
