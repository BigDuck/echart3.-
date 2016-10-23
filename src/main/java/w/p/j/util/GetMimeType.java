package w.p.j.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GetMimeType {
    public static void main(String args[]) throws FileNotFoundException {
        try {
//      POIFSFileSystem fs = new POIFSFileSystem();
            Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\Users\\WPJ587\\Desktop\\choice.xls"));
            if (workbook instanceof HSSFWorkbook) {
                System.out.println("Excel with xls");
            } else if (workbook instanceof XSSFWorkbook) {
                System.out.println("Excel with xlsx");
            }else{
                System.out.println("请根据正确模板提交数据");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }


    }
}