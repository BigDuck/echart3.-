package w.p.j.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import w.p.j.domain.Choice;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelImportUtil {
    public static List<Choice> parseExcel(InputStream fis) throws IOException {
        Workbook wb=null;
        try {
            wb = WorkbookFactory.create(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        List<Choice> data = new ArrayList<Choice>();
		Sheet sheet;
//        if(wb instanceof XSSFWorkbook){
//			wb= new XSSFWorkbook();
//        }else if(wb instanceof HSSFWorkbook){
//			wb =new HSSFWorkbook();
//		}

		sheet = wb.getSheetAt(0);
		int firstRow = sheet.getFirstRowNum();
		int lastRow = sheet.getLastRowNum();
		//除去表头和第一行
		for(int i = firstRow + 1; i<lastRow+1; i++) {
            Row row = sheet.getRow(i);
            int firstCell = row.getFirstCellNum();
            int lastCell = row.getLastCellNum();
            Choice choice=new Choice();
            // 题目
            choice.setTitle(row.getCell(0).getStringCellValue());
            // 选项A
            Map<String,Object> option=new HashMap<>();
            option.put("A",row.getCell(1).getStringCellValue());
            option.put("B",row.getCell(2).getStringCellValue());
            option.put("C",row.getCell(3).getStringCellValue());
            option.put("D",row.getCell(4).getStringCellValue());
            choice.setOption(option);
            choice.setRight(row.getCell(5).getStringCellValue());
            choice.setAnalysis(row.getCell(6).getStringCellValue());
//				for(int j=firstCell; j<lastCell; j++) {
//					System.out.println(firstCell);
//					XSSFCell cell = row.getCell(j);
//					System.out.println(cell.getStringCellValue());
//					//HSSFCell cell2 = sheet.getRow(firstRow + 1).getCell(j);
//				}
//
//				for(int j=firstCell; j<lastCell; j++) {
//
//					HSSFCell cell2 = sheet.getRow(firstRow + 1).getCell(j);
//					String key = cell2.getStringCellValue();
//
//					HSSFCell cell = row.getCell(j);
//
//					if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
//						cell.setCellType(HSSFCell.CELL_TYPE_STRING);
//					}
//					String val = cell.getStringCellValue();
//
//
//					if(i == firstRow + 1) {
//						break;
//					}else{
//						map.put(key, val);
//
//					}
////				System.out.println(map);
//				}
            data.add(choice);
        }
//		try {
//            FileCopyUtils.copy(fis,new FileOutputStream("F:"+ File.separator+"demo"+ File.separator+System.currentTimeMillis()+".xlsx"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
		System.out.println(data);
		return data;
	}
}
