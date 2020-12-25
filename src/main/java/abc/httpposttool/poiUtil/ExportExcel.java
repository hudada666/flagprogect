package abc.httpposttool.poiUtil;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

@Component
public class ExportExcel {


    //读取excel文件
    public Workbook readExcel(String fileName) {

        Workbook wb = null;
        if (fileName == null) {
            return null;
        }
        String extString = fileName.substring(fileName.lastIndexOf("."));
        InputStream excelData = null;
        try {
            excelData = new FileInputStream(fileName);
            if (".xls".equals(extString)) {
                //操作Excel2003以前（包括2003）的版本，扩展名是.xls
                return wb = new HSSFWorkbook(excelData);
                //操作Excel2007的版本，扩展名是.xlsx
            } else if (".xlsx".equals(extString)) {
                return wb = new XSSFWorkbook(excelData);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }


    //获取excel中的数据，封装成List返回
    public Map<String,List> getExcelData(String fileName) {
        //List<ExcelEntity> sheetsData = new ArrayList<ExcelEntity>();
        Map<String,List> excelMap = new LinkedHashMap();
        Map<String,String> insideMap = new LinkedHashMap();

        List<String> compList = new LinkedList<>();
        List<String> flsgList = new LinkedList<>();
        try {
            // 获得excel文件对象workbook
            Workbook wb = readExcel(fileName);
            Sheet sheetOne = wb.getSheetAt(0);
            //取出第1行
            Row rowOne = sheetOne.getRow(0);
            String traCode = rowOne.getCell(1).toString();
            compList.add(traCode);
            //单元格数据
            String compcellDate;
            String flagcellData;
            //循环行  sheet.getPhysicalNumberOfRows()是获取表格的总行数
            for (int i = 1; i < sheetOne.getPhysicalNumberOfRows(); i++) {
                // 从第2行开始取
                Row row = sheetOne.getRow(i);
                compcellDate = row.getCell(0).toString();
                flagcellData = row.getCell(1).toString();
                compList.add(compcellDate);
                flsgList.add(flagcellData);
            }
            excelMap.put("compList",compList);
            excelMap.put("flagList",flsgList);

        } catch (IndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return excelMap;
    }
}
