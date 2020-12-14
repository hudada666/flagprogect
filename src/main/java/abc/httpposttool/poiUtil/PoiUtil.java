package abc.httpposttool.poiUtil;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PoiUtil {

    //读取excel文件
    public static Workbook readExcel(String fileName) {
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
    public List<Map<String, String>> analyzeDemo(String fileName) {
        List<Map<String, String>> sheetsData = new ArrayList<Map<String, String>>();
        try {
            // 获得excel文件对象workbook
            Workbook wb = readExcel(fileName);
            // 循环excel文件sheet页
            System.out.println( wb.getNumberOfSheets());
            for (int sheets = 0; sheets < wb.getNumberOfSheets(); sheets++) {
                Map<String, String> rowData = new LinkedHashMap<String, String>();
                Sheet s = wb.getSheetAt(sheets);
                //循环行  sheet.getPhysicalNumberOfRows()是获取表格的总行数

                for (int i = 0; i < s.getPhysicalNumberOfRows(); i++) {
                    // 取出第i行
                    Row row = s.getRow(i);
                    rowData.put(row.getCell(0).toString(), row.getCell(1).toString());
                }
                sheetsData.add(rowData);
            }
        } catch (IndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return sheetsData;
    }

    public void exportExcel(List<Map<String,String>> excelData,List<String> returnData){
        // 创建一个workbook，对应一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 第二步，在webbook中添加sheet,对应Excel文件中的sheet
        for(int i=0;i<excelData.size();i++){
            HSSFSheet hssfSheet = workbook.createSheet("sheet"+i);
            //设置数据
            for (int row = 0; row < 1; row++) {
                HSSFRow sheetRow = hssfSheet.createRow(row);
                sheetRow.createCell(0).setCellValue(excelData.get(i).get("url"));
               // sheetRow.createCell(1).setCellValue(returnData.get(i));
            }
        }
        //写入文件
        try {
            workbook.write(new FileOutputStream(new File("D:\\return.xls")));
            workbook.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}
